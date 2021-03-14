package com.ml.prize.service.impl;

import com.ml.prize.entity.GameRule;
import com.ml.prize.enums.ResultCodeEnum;
import com.ml.prize.mapper.GameRuleMapper;
import com.ml.prize.service.GameRuleService;
import com.ml.prize.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Mr.ml
 * @date 2021/3/14
 */
@Service
public class GameRuleServiceImpl implements GameRuleService {

    @Resource
    private GameRuleMapper gameRuleMapper;

    @Override
    public ResultVO saveGameRule(GameRule gameRule) {
        int res = gameRuleMapper.insert(gameRule);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO deleteGameRule(Integer gameProductId) {
        int res = gameRuleMapper.deleteByPrimaryKey(gameProductId);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO updateGameRule(GameRule gameRule) {
        int res = gameRuleMapper.updateByPrimaryKey(gameRule);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO getGameRule(Integer gameRuleId) {
        GameRule gameRule = gameRuleMapper.selectByPrimaryKey(gameRuleId);
        if (gameRule == null) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

}
