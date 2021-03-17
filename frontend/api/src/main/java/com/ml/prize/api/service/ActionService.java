package com.ml.prize.api.service;

import com.ml.prize.common.vo.ResultVO;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

public interface ActionService {

    ResultVO action(Integer gameId, HttpServletRequest httpServletRequest);

    ResultVO info(Integer gameId);

}
