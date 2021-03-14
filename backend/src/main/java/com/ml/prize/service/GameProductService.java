package com.ml.prize.service;


import com.ml.prize.entity.GameProduct;
import com.ml.prize.vo.ResultVO;

public interface GameProductService {

    ResultVO saveGameProduct(GameProduct gameProduct);

    ResultVO deleteGameProduct(Integer gameProductId);

    ResultVO updateGameProduct(GameProduct gameProduct);

    ResultVO getGameProduct(Integer gameProductId);

}
