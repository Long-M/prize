package com.ml.prize.commons.mapper;

import com.ml.prize.commons.entity.GameProduct;
import com.ml.prize.commons.entity.GameProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GameProductMapper {
    long countByExample(GameProductExample example);

    int deleteByExample(GameProductExample example);

    int deleteByPrimaryKey(Integer gameProductId);

    int insert(GameProduct record);

    int insertSelective(GameProduct record);

    List<GameProduct> selectByExample(GameProductExample example);

    GameProduct selectByPrimaryKey(Integer gameProductId);

    int updateByExampleSelective(@Param("record") GameProduct record, @Param("example") GameProductExample example);

    int updateByExample(@Param("record") GameProduct record, @Param("example") GameProductExample example);

    int updateByPrimaryKeySelective(GameProduct record);

    int updateByPrimaryKey(GameProduct record);
}