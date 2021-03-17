package com.ml.prize.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ml.prize.api.config.LuaScript;
import com.ml.prize.api.service.ActionService;
import com.ml.prize.common.entity.*;
import com.ml.prize.common.enums.KafkaKeyEnum;
import com.ml.prize.common.enums.RedisKeyPrefixEnum;
import com.ml.prize.common.util.RedisUtils;
import com.ml.prize.common.vo.ResultVO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/3/16
 */
@Service
public class ActionServiceImpl implements ActionService {

    @Resource
    private RedisUtils redisUtils;
    @Resource
    private LuaScript luaScript;
    @Resource
    private KafkaTemplate kafkaTemplate;

    @Override
    public ResultVO action(Integer gameId, HttpServletRequest httpServletRequest) {
        Date now = new Date();
        Game game = (Game) redisUtils.get(RedisKeyPrefixEnum.INFO.name() + gameId);
        if (game == null || game.getStartTime().after(now)) {
            return new ResultVO(-1, "活动未开始", null);
        }
        if (now.after(game.getEndTime())) {
            return new ResultVO(-1, "活动已结束", null);
        }

        HttpSession session = httpServletRequest.getSession();
        User user = (User) redisUtils.get(RedisKeyPrefixEnum.SESSIONID.name() + session.getId());
        if (user == null) {
            return new ResultVO(-1, "用户未登录", null);
        } else {
            if (!redisUtils.hasKey(RedisKeyPrefixEnum.USERGAME.name() + user.getUserId() + "_" + game.getGameId())) {
                redisUtils.set(RedisKeyPrefixEnum.USERGAME.name() + user.getUserId() + "_" + game.getGameId(), 1, game.getStartTime().getTime() - game.getEndTime().getTime());
                UserGame userGame = new UserGame();
                userGame.setGameId(gameId);
                userGame.setUserId(user.getUserId());
                userGame.setCreateTime(new Date());
                kafkaTemplate.send(KafkaKeyEnum.TOPIC_PLAY.name(), JSONObject.toJSONString(userGame));
            }
        }

        Integer count = (Integer) redisUtils.get(RedisKeyPrefixEnum.USERHIT.name() + gameId + "_" + user.getUserId());
        if (count == null) {
            count = 0;
            redisUtils.set(RedisKeyPrefixEnum.USERHIT.name() + gameId + "_" + user.getUserId(), count, game.getEndTime().getTime() - now.getTime());
        }
        Integer maxCount = (Integer) redisUtils.hget(RedisKeyPrefixEnum.MAXGOAL.name() + gameId, user.getLevel() + "");
        maxCount = maxCount == null ? 0 : maxCount;
        if (maxCount > 0 && count >= maxCount) {
            return new ResultVO(-1, "您已达到最大中奖数", null);
        }

        Long token = luaScript.tokenCheck(RedisKeyPrefixEnum.TOKEN.name() + gameId, String.valueOf(now.getTime()));
        if (token == 0) {
            return new ResultVO(-1, "奖品已抽光", null);
        } else if (token == 1) {
            return new ResultVO(-1, "未中奖", null);
        }

        Product product = (Product) redisUtils.get(RedisKeyPrefixEnum.TOKEN.name() + gameId + "_" + token);
        redisUtils.incr(RedisKeyPrefixEnum.USERHIT.name() + gameId + "_" + user.getUserId(), 1);
        UserHit userHit = new UserHit();
        userHit.setUserId(user.getUserId());
        userHit.setGameId(gameId);
        userHit.setHitTime(now);
        userHit.setProductId(product.getProductId());
        kafkaTemplate.send(KafkaKeyEnum.TOPIC_HIT.name(), JSONObject.toJSONString(userHit));

        return new ResultVO(1, "恭喜中奖", product);
    }

    @Override
    public ResultVO info(Integer gameId) {
        Map map = new LinkedHashMap();
        map.put(RedisKeyPrefixEnum.INFO.name() + gameId, redisUtils.get(RedisKeyPrefixEnum.INFO.name() + gameId));
        List<Object> tokens = redisUtils.lrange(RedisKeyPrefixEnum.TOKENS.name() + gameId, 0, -1);
        Map tokenMap = new LinkedHashMap();
        tokens.forEach(o -> tokenMap.put(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(Long.valueOf(o.toString()) / 1000)),
                redisUtils.get(RedisKeyPrefixEnum.TOKEN.name() + gameId + "_" + o))
        );
        map.put(RedisKeyPrefixEnum.TOKENS.name() + gameId, tokenMap);
        map.put(RedisKeyPrefixEnum.MAXGOAL.name() + gameId, redisUtils.hmget(RedisKeyPrefixEnum.MAXGOAL.name() + gameId));
        map.put(RedisKeyPrefixEnum.MAXENTER.name() + gameId, redisUtils.hmget(RedisKeyPrefixEnum.MAXENTER.name() + gameId));
        return new ResultVO(200, "缓存信息", map);
    }

}
