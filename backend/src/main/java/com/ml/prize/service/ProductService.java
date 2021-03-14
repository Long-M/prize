package com.ml.prize.service;

import com.ml.prize.entity.Product;
import com.ml.prize.vo.ResultVO;

public interface ProductService {

    ResultVO saveProduct(Product product);

    ResultVO deleteProduct(Integer productId);

    ResultVO updateProduct(Product product);

    ResultVO getProduct(Integer productId);

}
