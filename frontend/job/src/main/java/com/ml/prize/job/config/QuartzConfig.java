package com.ml.prize.job.config;

import com.ml.prize.common.mapper.GameLoadMapper;
import com.ml.prize.common.mapper.GameMapper;
import com.ml.prize.common.mapper.GameProductMapper;
import com.ml.prize.common.mapper.GameRuleMapper;
import com.ml.prize.common.util.RedisUtils;
import com.ml.prize.job.task.GameJob;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.Resource;

/**
 * @author Mr.ml
 * @date 2021/3/15
 */
@Configuration
public class QuartzConfig {

    @Resource
    private GameMapper gameMapper;
    @Resource
    private GameProductMapper gameProductMapper;
    @Resource
    private GameRuleMapper gameRuleMapper;
    @Resource
    private GameLoadMapper gameLoadMapper;
    @Resource
    private RedisUtils redisUtils;

    @Bean
    public JobDetail jobDetail() {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("gameMapper", gameMapper);
        jobDataMap.put("gameProductMapper", gameProductMapper);
        jobDataMap.put("gameRuleMapper", gameRuleMapper);
        jobDataMap.put("gameLoadMapper", gameLoadMapper);
        jobDataMap.put("redisUtils", redisUtils);
        return JobBuilder.newJob(GameJob.class).setJobData(jobDataMap).build();
    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetail jobDetail){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetail);
        // cron表达式，每1分钟执行一次
        cronTriggerFactoryBean.setCronExpression("0 0/1 * * * ?");
        cronTriggerFactoryBean.setName("reptilianTrigger");
        return cronTriggerFactoryBean;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(Trigger trigger) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        // 用于quartz集群，QuartzScheduler启动时更新己存在的Job
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        // 延时启动，应用启动1秒后
        schedulerFactoryBean.setStartupDelay(1);
        // 注册触发器
        schedulerFactoryBean.setTriggers(trigger);
        return schedulerFactoryBean;
    }

}
