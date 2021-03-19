package com.ml.prize.commons.entity;

import org.springframework.beans.BeanUtils;

/**
 * @author Mr.ml
 * @date 2021/3/18
 */
public class UserDto extends User {

    /**
     * 参与的活动数，中奖数
     */
    private Integer games;
    private Integer products;

    public UserDto(User user) {
        BeanUtils.copyProperties(user, this);
    }

    public UserDto() {
        super();
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getProducts() {
        return products;
    }

    public void setProducts(Integer products) {
        this.products = products;
    }

}
