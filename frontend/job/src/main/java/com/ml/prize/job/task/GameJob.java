package com.ml.prize.job.task;

import com.ml.prize.commons.entity.*;
import com.ml.prize.commons.enums.RedisKeyPrefixEnum;
import com.ml.prize.commons.mapper.*;
import com.ml.prize.commons.util.RedisUtils;
import org.apache.commons.lang.time.DateUtils;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author Mr.ml
 * @date 2021/3/14
 */
@Component
public class GameJob implements Job {

    private GameMapper gameMapper;
    private GameProductMapper gameProductMapper;
    private GameRuleMapper gameRuleMapper;
    private GameLoadMapper gameLoadMapper;
    private RedisUtils redisUtils;

    public void init(JobExecutionContext jobExecutionContext) {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail()
                .getJobDataMap();
        this.gameMapper = (GameMapper) jobDataMap.get("gameMapper");
        this.gameProductMapper = (GameProductMapper) jobDataMap.get("gameProductMapper");
        this.gameRuleMapper = (GameRuleMapper) jobDataMap.get("gameRuleMapper");
        this.gameLoadMapper = (GameLoadMapper) jobDataMap.get("gameLoadMapper");
        this.redisUtils = (RedisUtils) jobDataMap.get("redisUtils");
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        init(jobExecutionContext);
        Date now = new Date();
        GameExample gameExample = new GameExample();
        gameExample.createCriteria().andStartTimeGreaterThan(now)
                .andStartTimeLessThanOrEqualTo(DateUtils.addMinutes(now, 1));
        List<Game> games = gameMapper.selectByExample(gameExample);
        if (games.size() == 0) {
            return;
        }

        games.forEach(game -> {
            long start = game.getStartTime().getTime();
            long end = game.getEndTime().getTime();
            long expire = (end - now.getTime()) / 1000;
            long duration = end - start;

            game.setStatus((byte)1);
            redisUtils.set(RedisKeyPrefixEnum.INFO.name() + game.getGameId(), game, -1);

            List<ProductDto> products = gameLoadMapper.getProductsByGameId(game.getGameId());
            HashMap<Integer, Product> productMap = new HashMap<>(products.size());
            products.forEach(product -> productMap.put(product.getProductId(), product));

            GameProductExample gameProductExample = new GameProductExample();
            gameProductExample.createCriteria().andGameIdEqualTo(game.getGameId());
            List<GameProduct> gameProducts = gameProductMapper.selectByExample(gameProductExample);

            List<Long> tokenList = new ArrayList<>();
            gameProducts.forEach(gameProduct -> {
                for (int i = 0; i < gameProduct.getAmount(); i++) {
                    long timeStamp = start + new Random().nextInt((int)duration);
                    long token = timeStamp * 1000 + new Random().nextInt(999);
                    tokenList.add(token);
                    redisUtils.set(RedisKeyPrefixEnum.TOKEN.name() + game.getGameId() + "_" + token, productMap.get(gameProduct.getProductId()), expire);
                }
            });
            Collections.sort(tokenList);

            redisUtils.rightPushAll(RedisKeyPrefixEnum.TOKENS.name() + game.getGameId(), tokenList);
            redisUtils.expire(RedisKeyPrefixEnum.TOKEN.name() + game.getGameId(), expire);

            GameRuleExample gameRuleExample = new GameRuleExample();
            gameRuleExample.createCriteria().andGameIdEqualTo(game.getGameId());
            List<GameRule> gameRules = gameRuleMapper.selectByExample(gameRuleExample);
            gameRules.forEach(gameRule -> {
                redisUtils.set(RedisKeyPrefixEnum.MAXGOAL.name() + game.getGameId(), gameRule.getUserLevel() + "", gameRule.getGoalTimes());
                redisUtils.set(RedisKeyPrefixEnum.MAXENTER.name() + game.getGameId(), gameRule.getUserLevel() + "", gameRule.getEnterTimes());
            });

            redisUtils.expire(RedisKeyPrefixEnum.MAXGOAL.name() + game.getGameId(), expire);
            redisUtils.expire(RedisKeyPrefixEnum.MAXENTER.name() + game.getGameId(), expire);

            game.setStatus((byte)1);
            gameMapper.updateByPrimaryKey(game);
        });
    }

}
