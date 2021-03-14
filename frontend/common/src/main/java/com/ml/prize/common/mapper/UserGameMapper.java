package com.ml.prize.common.mapper;

import com.ml.prize.common.entity.UserGame;
import com.ml.prize.common.entity.UserGameExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserGameMapper {
    long countByExample(UserGameExample example);

    int deleteByExample(UserGameExample example);

    int deleteByPrimaryKey(Integer userGameId);

    int insert(UserGame record);

    int insertSelective(UserGame record);

    List<UserGame> selectByExample(UserGameExample example);

    UserGame selectByPrimaryKey(Integer userGameId);

    int updateByExampleSelective(@Param("record") UserGame record, @Param("example") UserGameExample example);

    int updateByExample(@Param("record") UserGame record, @Param("example") UserGameExample example);

    int updateByPrimaryKeySelective(UserGame record);

    int updateByPrimaryKey(UserGame record);
}