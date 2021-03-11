package com.ml.prize.entity;

public class GameRule {
    private Integer gameRuleId;

    private Integer gameId;

    private Integer userLevel;

    private Short enterTimes;

    private Short goalTimes;

    public Integer getGameRuleId() {
        return gameRuleId;
    }

    public void setGameRuleId(Integer gameRuleId) {
        this.gameRuleId = gameRuleId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Short getEnterTimes() {
        return enterTimes;
    }

    public void setEnterTimes(Short enterTimes) {
        this.enterTimes = enterTimes;
    }

    public Short getGoalTimes() {
        return goalTimes;
    }

    public void setGoalTimes(Short goalTimes) {
        this.goalTimes = goalTimes;
    }
}