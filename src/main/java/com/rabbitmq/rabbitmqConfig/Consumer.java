package com.rabbitmq.rabbitmqConfig;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private String message;
    @RabbitListener(queues = "spring-boot")
    public void consume(String message){
        System.out.println("receive....!");
        System.out.println(message);
    }

}
