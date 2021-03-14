package com.ml.prize.service.impl;

import com.ml.prize.entity.Product;
import com.ml.prize.enums.ResultCodeEnum;
import com.ml.prize.mapper.ProductMapper;
import com.ml.prize.service.ProductService;
import com.ml.prize.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Mr.ml
 * @date 2021/3/13
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public ResultVO saveProduct(Product product) {
        int res = productMapper.insert(product);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO deleteProduct(Integer productId) {
        int res = productMapper.deleteByPrimaryKey(productId);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO updateProduct(Product product) {
        int res = productMapper.updateByPrimaryKey(product);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO getProduct(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        if (product == null) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

}
