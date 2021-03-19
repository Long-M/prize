package com.ml.prize.commons.mapper;

import com.ml.prize.commons.entity.UserGame;
import com.ml.prize.commons.entity.UserGameExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    @Select("select count(user_game_id) as num from user_game where user_id = #{userId} group by user_id")
    int getGamesNumByUserId(Integer userId);

    @Select("select count(user_hit_id) as num from user_hit where user_id = #{userId} group by user_id")
    int getPrizesNumByUserId(Integer userId);
}