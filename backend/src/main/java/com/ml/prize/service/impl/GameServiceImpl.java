package com.ml.prize.service.impl;

import com.ml.prize.entity.Game;
import com.ml.prize.entity.GameProductExample;
import com.ml.prize.entity.GameRuleExample;
import com.ml.prize.enums.ResultCodeEnum;
import com.ml.prize.mapper.GameMapper;
import com.ml.prize.mapper.GameProductMapper;
import com.ml.prize.mapper.GameRuleMapper;
import com.ml.prize.service.GameService;
import com.ml.prize.vo.ResultVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Mr.ml
 * @date 2021/3/14
 */
@Service
public class GameServiceImpl implements GameService {

    @Resource
    private GameMapper gameMapper;
    @Resource
    private GameProductMapper gameProductMapper;
    @Resource
    private GameRuleMapper gameRuleMapper;

    @Override
    public ResultVO saveGame(Game game) {
        int res = gameMapper.insert(game);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVO deleteGame(Integer gameId) {
        GameProductExample gameProductExample = new GameProductExample();
        gameProductExample.createCriteria().andGameIdEqualTo(gameId);
        int res = gameProductMapper.deleteByExample(gameProductExample);

        GameRuleExample gameRuleExample = new GameRuleExample();
        gameRuleExample.createCriteria().andGameIdEqualTo(gameId);
        res |= gameRuleMapper.deleteByExample(gameRuleExample);

        res |= gameMapper.deleteByPrimaryKey(gameId);

        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO updateGame(Game game) {
        int res = gameMapper.updateByPrimaryKey(game);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO getGame(Integer gameId) {
        Game game = gameMapper.selectByPrimaryKey(gameId);
        if (game == null) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

}
