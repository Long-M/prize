package com.ml.prize.commons.mapper;

import com.ml.prize.commons.entity.ProductDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/3/14
 */
public interface GameLoadMapper {

    @Select("select p.*, gp.amount from product p " +
            "inner join game_product gp on p.product_id = gp.product_id " +
            "where gp.game_id = #{gameId,jdbcType=INTEGER}")
    List<ProductDto> getProductsByGameId(Integer gameId);

}
