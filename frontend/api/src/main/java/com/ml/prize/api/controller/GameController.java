package com.ml.prize.api.controller;

import com.ml.prize.api.service.GameService;
import com.ml.prize.commons.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Mr.ml
 * @date 2021/3/18
 */
@RestController
@RequestMapping(value = "/api/game")
@Api(tags = {"活动模块"})
public class GameController {

    @Resource
    private GameService gameService;

    @GetMapping("/list/{status}/{curPage}/{limit}")
    @ApiOperation(value = "活动列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "活动状态（-1=全部，0=未开始，1=进行中，2=已结束）", example = "-1", required = true),
            @ApiImplicitParam(name = "curPage", value = "第几页", defaultValue = "1", dataType = "int", example = "1", required = true),
            @ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", dataType = "int", example = "3", required = true)
    })
    public ResultVO list(@PathVariable int status,
                         @PathVariable int curPage,
                         @PathVariable int limit) {
        return gameService.list(status, curPage, limit);
    }

    @GetMapping("/info/{gameId}")
    @ApiOperation(value = "活动信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "gameId", value = "活动id", example = "1", required = true)
    })
    public ResultVO info(@PathVariable int gameId) {
        return gameService.info(gameId);
    }

    @GetMapping("/products/{gameId}")
    @ApiOperation(value = "奖品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "gameId", value = "活动id", example = "1", required = true)
    })
    public ResultVO products(@PathVariable int gameId) {
        return gameService.info(gameId);
    }

    @GetMapping("/hit/{gameId}/{curPage}/{limit}")
    @ApiOperation(value = "中奖列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "gameId", value = "活动id", dataType = "int", example = "1", required = true),
            @ApiImplicitParam(name = "curPage", value = "第几页", defaultValue = "1", dataType = "int", example = "1", required = true),
            @ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", dataType = "int", example = "3", required = true)
    })
    public ResultVO hit(@PathVariable int gameId, @PathVariable int curPage, @PathVariable int limit) {
        return gameService.hit(gameId, curPage, limit);
    }

}
