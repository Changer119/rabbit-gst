package com.changer.rabbit.gst;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Project: rabbit-gst
 * @Author: fcjiang
 * @Date: 2017-06-03
 */
@SpringBootApplication
@EnableScheduling
public class RabbitGstApplication {

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory factory) {
        return new RabbitAdmin(factory);
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitGstApplication.class, args);
    }
}
