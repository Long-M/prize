package com.ml.prize.service;

import com.ml.prize.entity.Game;
import com.ml.prize.vo.ResultVO;

/**
 * @author Mr.ml
 * @date 2021/3/14
 */
public interface GameService {

    ResultVO saveGame(Game game);

    ResultVO deleteGame(Integer gameId);

    ResultVO updateGame(Game game);

    ResultVO getGame(Integer gameId);

}
