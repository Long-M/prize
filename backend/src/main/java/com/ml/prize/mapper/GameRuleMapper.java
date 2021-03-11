package com.ml.prize.mapper;

import com.ml.prize.entity.GameRule;

public interface GameRuleMapper {
    int deleteByPrimaryKey(Integer gameRuleId);

    int insert(GameRule record);

    int insertSelective(GameRule record);

    GameRule selectByPrimaryKey(Integer gameRuleId);

    int updateByPrimaryKeySelective(GameRule record);

    int updateByPrimaryKey(GameRule record);
}