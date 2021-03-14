package com.ml.prize.controller;

import com.ml.prize.entity.GameRule;
import com.ml.prize.service.GameRuleService;
import com.ml.prize.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Mr.ml
 * @date 2021/3/14
 */
@RestController
@RequestMapping("/gameRule")
public class GameRuleController {

    @Resource
    private GameRuleService gameRuleService;

    @PostMapping("/add")
    public ResultVO addGameRule(GameRule gameRule) {
        return gameRuleService.saveGameRule(gameRule);
    }

    @DeleteMapping("/delete/{gameRuleId}")
    public ResultVO deleteGameRule(@PathVariable("gameRuleId") Integer gameRuleId) {
        return gameRuleService.deleteGameRule(gameRuleId);
    }

    @PutMapping("/update")
    public ResultVO updateGameRule(GameRule gameRule) {
        return gameRuleService.updateGameRule(gameRule);
    }

    @GetMapping("/get/{gameRuleId}")
    public ResultVO getGameRule(@PathVariable("gameRuleId") Integer gameRuleId) {
        return gameRuleService.getGameRule(gameRuleId);
    }

}
