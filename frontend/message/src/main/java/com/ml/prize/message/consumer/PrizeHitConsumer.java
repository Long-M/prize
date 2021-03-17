package com.ml.prize.message.consumer;

import com.alibaba.fastjson.JSON;
import com.ml.prize.common.entity.UserHit;
import com.ml.prize.common.mapper.UserHitMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mr.ml
 * @date 2021/3/16
 */
@Component
public class PrizeHitConsumer {

    @Resource
    private UserHitMapper userHitMapper;

    @KafkaListener(topics = "topic.hit")
    public void consumer(String JSONString) {
        UserHit userHit = JSON.parseObject(JSONString, UserHit.class);
        userHitMapper.insert(userHit);
    }

}
