package com.changer.rabbit.gst.biz.fanout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @Project: rabbit-gst
 * @Author: fcjiang
 * @Date: 2017-06-03
 */
@Slf4j
@Component
public class Subscriber {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "fanoutQueue1", autoDelete = "true"),
            exchange = @Exchange(value = "fanoutExchange", type = "fanout", autoDelete = "true")))
    public void consume1(@Payload String msg) {
        log.info("Consumer[1] recv message {}", msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "fanoutQueue2", autoDelete = "true"),
            exchange = @Exchange(value = "fanoutExchange", type = "fanout", autoDelete = "true")))
    public void consume2(@Payload String msg) {
        log.info("Consumer[2] recv message {}", msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "fanoutQueue3", autoDelete = "true"),
            exchange = @Exchange(value = "fanoutExchange", type = "fanout", autoDelete = "true")))
    public void consume3(@Payload String msg) {
        log.info("Consumer[3] recv message {}", msg);
    }
}
