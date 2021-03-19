package com.ml.prize.commons.enums;

/**
 * @author Mr.ml
 * @date 2021/3/16
 */
public enum KafkaKeyEnum {

    // 参与活动队列
    TOPIC_PLAY("topic.play"),
    // 中奖队列名称
    TOPIC_HIT("topic.hit");

    private String value;

    KafkaKeyEnum(String value) {
        this.value = value;
    }

}
