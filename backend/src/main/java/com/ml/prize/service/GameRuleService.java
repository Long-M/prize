package com.ml.prize.service;

import com.ml.prize.entity.GameRule;
import com.ml.prize.vo.ResultVO;

public interface GameRuleService {

    ResultVO saveGameRule(GameRule gameRule);

    ResultVO deleteGameRule(Integer gameRuleId);

    ResultVO updateGameRule(GameRule gameRule);

    ResultVO getGameRule(Integer gameRuleId);

}
