package com.ml.prize.service.impl;

import com.ml.prize.entity.Game;
import com.ml.prize.enums.ResultCodeEnum;
import com.ml.prize.mapper.GameMapper;
import com.ml.prize.service.GameService;
import com.ml.prize.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Mr.ml
 * @date 2021/3/14
 */
@Service
public class GameServiceImpl implements GameService {

    @Resource
    private GameMapper gameMapper;

    @Override
    public ResultVO saveGame(Game game) {
        int res = gameMapper.insert(game);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO deleteGame(Integer gameId) {
        int res = gameMapper.deleteByPrimaryKey(gameId);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO updateGame(Game game) {
        int res = gameMapper.updateByPrimaryKey(game);
        if (res == -1) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

    @Override
    public ResultVO getGame(Integer gameId) {
        Game game = gameMapper.selectByPrimaryKey(gameId);
        if (game == null) {
            return ResultVO.error(ResultCodeEnum.FAIL);
        }
        return ResultVO.success();
    }

}
