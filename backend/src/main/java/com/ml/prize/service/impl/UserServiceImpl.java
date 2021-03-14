package com.ml.prize.service.impl;

import com.ml.prize.entity.User;
import com.ml.prize.enums.ResultCodeEnum;
import com.ml.prize.mapper.UserMapper;
import com.ml.prize.service.UserService;
import com.ml.prize.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Mr.ml
 * @date 2021/3/14
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public ResultVO saveUser(User user) {
        int res = userMapper.insert(user);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO deleteUser(Integer userId) {
        int res = userMapper.deleteByPrimaryKey(userId);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO updateUser(User user) {
        int res = userMapper.updateByPrimaryKey(user);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO getUser(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

}
