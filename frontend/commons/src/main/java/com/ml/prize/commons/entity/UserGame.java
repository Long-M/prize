package com.ml.prize.commons.entity;

import java.util.Date;

public class UserGame {
    private Integer userGameId;

    private Integer userId;

    private Integer gameId;

    private Date createTime;

    public Integer getUserGameId() {
        return userGameId;
    }

    public void setUserGameId(Integer userGameId) {
        this.userGameId = userGameId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}