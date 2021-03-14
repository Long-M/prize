package com.ml.prize.controller;

import com.ml.prize.entity.User;
import com.ml.prize.service.UserService;
import com.ml.prize.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/add")
    public ResultVO addUser(User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public ResultVO deleteUser(@PathVariable("userId") Integer userId) {
        return userService.deleteUser(userId);
    }

    @PutMapping("/update")
    public ResultVO updateUser(User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/get/{userId}")
    public ResultVO getUser(@PathVariable("userId") Integer userId) {
        return userService.getUser(userId);
    }

}
