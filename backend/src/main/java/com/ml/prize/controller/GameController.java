package com.ml.prize.controller;

import com.ml.prize.entity.Game;
import com.ml.prize.service.GameService;
import com.ml.prize.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Mr.ml
 * @date 2021/3/14
 */
@RestController
@RequestMapping("/game")
public class GameController {

    @Resource
    private GameService gameService;

    @PostMapping("/add")
    public ResultVO addGame(Game game) {
        return gameService.saveGame(game);
    }

    @DeleteMapping("/delete/{gameId}")
    public ResultVO deleteGame(@PathVariable("gameId") Integer gameId) {
        return gameService.deleteGame(gameId);
    }

    @PutMapping("/update")
    public ResultVO updateGame(Game game) {
        return gameService.updateGame(game);
    }

    @GetMapping("/get/{gameId}")
    public ResultVO getGame(@PathVariable("gameId") Integer gameId) {
        return gameService.getGame(gameId);
    }

}
