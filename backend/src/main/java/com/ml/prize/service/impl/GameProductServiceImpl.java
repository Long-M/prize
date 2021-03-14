package com.ml.prize.service.impl;

import com.ml.prize.entity.GameProduct;
import com.ml.prize.enums.ResultCodeEnum;
import com.ml.prize.mapper.GameProductMapper;
import com.ml.prize.service.GameProductService;
import com.ml.prize.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Mr.ml
 * @date 2021/3/14
 */
@Service
public class GameProductServiceImpl implements GameProductService {

    @Resource
    private GameProductMapper gameProductMapper;

    @Override
    public ResultVO saveGameProduct(GameProduct gameProduct) {
        int res = gameProductMapper.insert(gameProduct);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO deleteGameProduct(Integer gameProductId) {
        int res = gameProductMapper.deleteByPrimaryKey(gameProductId);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO updateGameProduct(GameProduct gameProduct) {
        int res = gameProductMapper.updateByPrimaryKey(gameProduct);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO getGameProduct(Integer gameProductId) {
        GameProduct gameProduct = gameProductMapper.selectByPrimaryKey(gameProductId);
        if (gameProduct == null) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

}
