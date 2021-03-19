package com.ml.prize.commons.entity;

import java.util.Date;

public class UserHit {
    private Integer userHitId;

    private Integer userId;

    private Integer gameId;

    private Integer productId;

    private Date hitTime;

    public Integer getUserHitId() {
        return userHitId;
    }

    public void setUserHitId(Integer userHitId) {
        this.userHitId = userHitId;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getHitTime() {
        return hitTime;
    }

    public void setHitTime(Date hitTime) {
        this.hitTime = hitTime;
    }
}