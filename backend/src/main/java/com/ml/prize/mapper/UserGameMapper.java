package com.ml.prize.mapper;

import com.ml.prize.entity.UserGame;

public interface UserGameMapper {
    int deleteByPrimaryKey(Integer userGameId);

    int insert(UserGame record);

    int insertSelective(UserGame record);

    UserGame selectByPrimaryKey(Integer userGameId);

    int updateByPrimaryKeySelective(UserGame record);

    int updateByPrimaryKey(UserGame record);
}