package com.rabbitmq.rabbitmqConfig;

import com.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import static com.rabbitmq.util.RabbitmqConstant.*;
public class Publisher {
    RabbitTemplate rabbitTemplate;
    public Publisher(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }
    public void getUser(User user){
        try{
            rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_USER, ROUTING_KEY_USER, "hello------");
        }catch(Exception exception){
        }
    }
}
