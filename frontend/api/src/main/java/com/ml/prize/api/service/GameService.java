package com.ml.prize.api.service;

import com.ml.prize.commons.vo.ResultVO;

public interface GameService {

    ResultVO list(Integer status, Integer curPage, Integer limit);

    ResultVO info(Integer gameId);

    ResultVO products(Integer gameId);

    ResultVO hit(Integer gameId, Integer curPage, Integer limit);

}
