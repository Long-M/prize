package com.ml.prize.message.consumer;

import com.alibaba.fastjson.JSON;
import com.ml.prize.commons.entity.UserGame;
import com.ml.prize.commons.mapper.UserGameMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mr.ml
 * @date 2021/3/16
 */
@Component
public class PrizeGameConsumer {

    @Resource
    private UserGameMapper userGameMapper;

    @KafkaListener(topics = "topic.play")
    public void consumer(String JSONString) {
        UserGame userGame = JSON.parseObject(JSONString, UserGame.class);
        userGameMapper.insert(userGame);
    }

}
