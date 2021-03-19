package com.ml.prize.api.service.impl;

import com.github.pagehelper.PageHelper;
import com.ml.prize.api.service.GameService;
import com.ml.prize.commons.entity.GameExample;
import com.ml.prize.commons.entity.ViewUserHit;
import com.ml.prize.commons.entity.ViewUserHitExample;
import com.ml.prize.commons.mapper.GameLoadMapper;
import com.ml.prize.commons.mapper.GameMapper;
import com.ml.prize.commons.mapper.ViewUserHitMapper;
import com.ml.prize.commons.vo.PageBean;
import com.ml.prize.commons.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/3/18
 */
@Service
public class GameServiceImpl implements GameService {

    @Resource
    private GameLoadMapper gameLoadMapper;
    @Resource
    private GameMapper gameMapper;
    @Resource
    private ViewUserHitMapper viewUserHitMapper;

    @Override
    public ResultVO list(Integer status, Integer curPage, Integer limit) {
        Date now = new Date();
        GameExample gameExample = new GameExample();
        GameExample.Criteria c = gameExample.createCriteria();
        switch (status) {
            case -1:
                // 查全部
                break;
            case 0:
                // 未开始
                c.andStartTimeGreaterThan(now);
                break;
            case 1:
                // 进行中
                c.andStartTimeLessThanOrEqualTo(now).andEndTimeGreaterThan(now);
                break;
            case 2:
                // 已结束
                c.andEndTimeLessThanOrEqualTo(now);
                break;
        }
        long total = gameMapper.countByExample(gameExample);
        gameExample.setOrderByClause("startTime desc");
        PageHelper.startPage(curPage, limit);
        return new ResultVO(1, "成功", new PageBean(curPage, limit, total, gameMapper.selectByExample(gameExample)));
    }

    @Override
    public ResultVO info(Integer gameId) {
        return new ResultVO(1, "成功", gameMapper.selectByPrimaryKey(gameId));
    }

    @Override
    public ResultVO products(Integer gameId) {
        return new ResultVO(1, "成功", gameLoadMapper.getProductsByGameId(gameId));
    }

    @Override
    public ResultVO hit(Integer gameId, Integer curPage, Integer limit) {
        ViewUserHitExample viewUserHitExample = new ViewUserHitExample();
        viewUserHitExample.createCriteria().andGameIdEqualTo(gameId);
        long total = viewUserHitMapper.countByExample(viewUserHitExample);
        PageHelper.startPage(curPage, limit);
        List<ViewUserHit> all = viewUserHitMapper.selectByExample(viewUserHitExample);
        return new ResultVO(1, "成功", new PageBean(curPage, limit, total, all));
    }

}
