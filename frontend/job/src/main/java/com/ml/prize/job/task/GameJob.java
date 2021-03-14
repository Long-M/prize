package com.ml.prize.job.task;

import com.ml.prize.common.entity.Game;
import com.ml.prize.common.entity.GameExample;
import com.ml.prize.common.mapper.GameMapper;
import org.apache.commons.lang.time.DateUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Mr.ml
 * @date 2021/3/14
 */
public class GameJob implements Job {

    @Resource
    private GameMapper gameMapper;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date now = new Date();
        GameExample gameExample = new GameExample();
        gameExample.createCriteria().andStartTimeGreaterThan(now)
                .andStartTimeLessThanOrEqualTo(DateUtils.addMinutes(now, 1));
        List<Game> games = gameMapper.selectByExample(gameExample);
        if (games.size() == 0) {
            return;
        }
    }

}
