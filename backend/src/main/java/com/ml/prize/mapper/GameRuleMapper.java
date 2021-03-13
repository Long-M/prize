package com.ml.prize.mapper;

import com.ml.prize.entity.GameRule;
import com.ml.prize.entity.GameRuleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GameRuleMapper {
    long countByExample(GameRuleExample example);

    int deleteByExample(GameRuleExample example);

    int deleteByPrimaryKey(Integer gameRuleId);

    int insert(GameRule record);

    int insertSelective(GameRule record);

    List<GameRule> selectByExample(GameRuleExample example);

    GameRule selectByPrimaryKey(Integer gameRuleId);

    int updateByExampleSelective(@Param("record") GameRule record, @Param("example") GameRuleExample example);

    int updateByExample(@Param("record") GameRule record, @Param("example") GameRuleExample example);

    int updateByPrimaryKeySelective(GameRule record);

    int updateByPrimaryKey(GameRule record);
}