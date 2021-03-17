package com.ml.prize.api.controller;

import com.ml.prize.api.service.ActionService;
import com.ml.prize.common.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Mr.ml
 * @date 2021/3/16
 */
@Api("抽奖模块")
@RestController
@RequestMapping("/api")
public class ActionController {

    @Resource
    private ActionService actionService;

    @GetMapping("go/{gameId}")
    @ApiOperation("抽奖")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "gameId", value = "活动id", example = "1", required = true)
    )
    public ResultVO action(@PathVariable("gameId") Integer gameId, HttpServletRequest httpServletRequest) {
        return actionService.action(gameId, httpServletRequest);
    }

    @GetMapping("/info/{gameId}")
    @ApiOperation(value = "缓存信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="gameId", value = "活动id", example = "1", required = true)
    })
    public ResultVO info(@PathVariable Integer gameId){
        return actionService.info(gameId);
    }

}
