package com.ml.prize.controller;

import com.ml.prize.entity.GameProduct;
import com.ml.prize.service.GameProductService;
import com.ml.prize.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Mr.ml
 * @date 2021/3/14
 */
@RestController
@RequestMapping("/gameProduct")
public class GameProductController {

    @Resource
    private GameProductService gameProductService;

    @PostMapping("/add")
    public ResultVO addGameProduct(GameProduct gameProduct) {
        return gameProductService.saveGameProduct(gameProduct);
    }

    @DeleteMapping("/delete/{gameProductId}")
    public ResultVO deleteGameProduct(@PathVariable("gameProductId") Integer gameProductId) {
        return gameProductService.deleteGameProduct(gameProductId);
    }

    @PutMapping("/update")
    public ResultVO updateGameProduct(GameProduct gameProduct) {
        return gameProductService.updateGameProduct(gameProduct);
    }

    @GetMapping("/get/{gameProductId}")
    public ResultVO getGameProduct(@PathVariable("gameProductId") Integer gameProductId) {
        return gameProductService.getGameProduct(gameProductId);
    }

}
