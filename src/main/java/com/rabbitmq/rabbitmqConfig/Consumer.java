package com.rabbitmq.rabbitmqConfig;

import com.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
//    @RabbitListener(queues = "user")
//    public void consume(String message){
//        System.out.println("receive....!");
//        System.out.println(message);
//    }

}
