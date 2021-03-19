package com.ml.prize.commons.enums;

/**
 * @author Mr.ml
 * @date 2021/3/14
 */
public enum RedisKeyPrefixEnum {

    // 活动信息
    INFO("game_info_"),
    // 令牌前缀
    TOKEN("game_token_"),
    // 令牌桶key
    TOKENS("game_tokens_"),
    // 最大中奖数
    MAXGOAL("game_maxgoal_"),
    // 最大抽奖数
    MAXENTER("game_maxenter_"),
    // redis session
    SESSIONID("user_sessionid_"),
    // 用户中奖数
    USERHIT("user_hit_"),
    // 用户登录错误次数
    USERLOGINTIMES("user_login_times_"),
    // 用户是否参与该活动
    USERGAME("user_game_");

    private String value;

    RedisKeyPrefixEnum(String value) {
        this.value = value;
    }

}
