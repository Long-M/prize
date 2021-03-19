package com.ml.prize.commons.mapper;

import com.ml.prize.commons.entity.UserHit;
import com.ml.prize.commons.entity.UserHitExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserHitMapper {
    long countByExample(UserHitExample example);

    int deleteByExample(UserHitExample example);

    int deleteByPrimaryKey(Integer userHitId);

    int insert(UserHit record);

    int insertSelective(UserHit record);

    List<UserHit> selectByExample(UserHitExample example);

    UserHit selectByPrimaryKey(Integer userHitId);

    int updateByExampleSelective(@Param("record") UserHit record, @Param("example") UserHitExample example);

    int updateByExample(@Param("record") UserHit record, @Param("example") UserHitExample example);

    int updateByPrimaryKeySelective(UserHit record);

    int updateByPrimaryKey(UserHit record);
}