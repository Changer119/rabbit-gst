package com.changer.rabbit.gst.biz.fanout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Project: rabbit-gst
 * @Author: fcjiang
 * @Date: 2017-06-03
 */
@Slf4j
@Component
public class Publisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 2 * 1000L)
    public void publish() {
        long currentTs = System.currentTimeMillis();
        rabbitTemplate.convertAndSend("fanoutExchange", "", currentTs);
        log.info("publish message: {}", currentTs);
    }
}
