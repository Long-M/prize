package com.ml.prize.api.controller;

import com.ml.prize.api.service.UserService;
import com.ml.prize.commons.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Mr.ml
 * @date 2021/3/18
 */
@RestController
@RequestMapping(value = "/api")
@Api(tags = {"登录模块"})
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    public ResultVO login(HttpServletRequest httpServletRequest, @RequestParam String username, @RequestParam String password) {
        return userService.login(httpServletRequest, username, password);
    }

    @GetMapping("/logout")
    @ApiOperation(value = "退出")
    public ResultVO logout(HttpServletRequest httpServletRequest) {
        return userService.logout(httpServletRequest);
    }

}
