package com.ml.prize.api.controller;

import com.ml.prize.api.service.UserService;
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
import javax.servlet.http.HttpServletRequest;

/**
 * @author Mr.ml
 * @date 2021/3/18
 */
@RestController
@RequestMapping(value = "/api/user")
@Api(tags = {"用户模块"})
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/info")
    @ApiOperation(value = "用户信息")
    public ResultVO info(HttpServletRequest httpServletRequest) {
        return userService.info(httpServletRequest);
    }

    @GetMapping("/hit/{gameId}/{curPage}/{limit}")
    @ApiOperation(value = "我的奖品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "gameId", value = "活动id（-1=全部）", dataType = "int", example = "1", required = true),
            @ApiImplicitParam(name = "curPage", value = "第几页", defaultValue = "1", dataType = "int", example = "1"),
            @ApiImplicitParam(name = "limit", value = "每页条数", defaultValue = "10", dataType = "int", example = "3")
    })
    public ResultVO hit(@PathVariable int gameId,
                        @PathVariable int curPage,
                        @PathVariable int limit,
                        HttpServletRequest httpServletRequest) {
        return userService.hit(gameId, curPage, limit, httpServletRequest);
    }

}
