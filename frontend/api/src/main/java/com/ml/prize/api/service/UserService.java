package com.ml.prize.api.service;

import com.ml.prize.commons.vo.ResultVO;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    ResultVO login(HttpServletRequest httpServletRequest, String username, String password);

    ResultVO logout(HttpServletRequest httpServletRequest);

    ResultVO info(HttpServletRequest httpServletRequest);

    ResultVO hit(Integer gameId, Integer curPage, Integer limit, HttpServletRequest httpServletRequest);

}
