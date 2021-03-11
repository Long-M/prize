package com.ml.prize.mapper;

import com.ml.prize.entity.UserHit;

public interface UserHitMapper {
    int deleteByPrimaryKey(Integer userHitId);

    int insert(UserHit record);

    int insertSelective(UserHit record);

    UserHit selectByPrimaryKey(Integer userHitId);

    int updateByPrimaryKeySelective(UserHit record);

    int updateByPrimaryKey(UserHit record);
}