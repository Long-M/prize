package com.ml.prize.commons.mapper;

import com.ml.prize.commons.entity.ViewUserHit;
import com.ml.prize.commons.entity.ViewUserHitExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ViewUserHitMapper {
    long countByExample(ViewUserHitExample example);

    int deleteByExample(ViewUserHitExample example);

    int insert(ViewUserHit record);

    int insertSelective(ViewUserHit record);

    List<ViewUserHit> selectByExample(ViewUserHitExample example);

    int updateByExampleSelective(@Param("record") ViewUserHit record, @Param("example") ViewUserHitExample example);

    int updateByExample(@Param("record") ViewUserHit record, @Param("example") ViewUserHitExample example);
}