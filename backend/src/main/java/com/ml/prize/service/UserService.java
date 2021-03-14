package com.ml.prize.service;

import com.ml.prize.entity.User;
import com.ml.prize.vo.ResultVO;

public interface UserService {

    ResultVO saveUser(User user);

    ResultVO deleteUser(Integer userId);

    ResultVO updateUser(User user);

    ResultVO getUser(Integer userId);

}
