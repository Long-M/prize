package com.ml.prize.commons.mapper;

import com.ml.prize.commons.entity.Game;
import com.ml.prize.commons.entity.GameExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GameMapper {
    long countByExample(GameExample example);

    int deleteByExample(GameExample example);

    int deleteByPrimaryKey(Integer gameId);

    int insert(Game record);

    int insertSelective(Game record);

    List<Game> selectByExample(GameExample example);

    Game selectByPrimaryKey(Integer gameId);

    int updateByExampleSelective(@Param("record") Game record, @Param("example") GameExample example);

    int updateByExample(@Param("record") Game record, @Param("example") GameExample example);

    int updateByPrimaryKeySelective(Game record);

    int updateByPrimaryKey(Game record);
}