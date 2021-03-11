package com.ml.prize.mapper;

import com.ml.prize.entity.GameProduct;

public interface GameProductMapper {
    int deleteByPrimaryKey(Integer gameProductId);

    int insert(GameProduct record);

    int insertSelective(GameProduct record);

    GameProduct selectByPrimaryKey(Integer gameProductId);

    int updateByPrimaryKeySelective(GameProduct record);

    int updateByPrimaryKey(GameProduct record);
}