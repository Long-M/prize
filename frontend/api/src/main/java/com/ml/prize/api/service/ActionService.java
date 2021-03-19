package com.ml.prize.api.service;

import com.ml.prize.commons.vo.ResultVO;

import javax.servlet.http.HttpServletRequest;

public interface ActionService {

    ResultVO action(Integer gameId, HttpServletRequest httpServletRequest);

    ResultVO info(Integer gameId);

}
