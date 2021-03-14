package com.ml.prize.common.entity;

public class GameProduct {
    private Integer gameProductId;

    private Integer gameId;

    private Integer productId;

    private Short amount;

    public Integer getGameProductId() {
        return gameProductId;
    }

    public void setGameProductId(Integer gameProductId) {
        this.gameProductId = gameProductId;
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

    public Short getAmount() {
        return amount;
    }

    public void setAmount(Short amount) {
        this.amount = amount;
    }
}