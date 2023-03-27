package com.rabbitmq.controller;

import com.rabbitmq.entity.User;
import com.rabbitmq.rabbitmqConfig.Config;
import com.rabbitmq.rabbitmqConfig.Consumer;
import com.rabbitmq.repository.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    UserRepository userRepository;
    RabbitTemplate rabbitTemplate;
    @Autowired
    Config config;
    public HomeController(UserRepository userRepository, RabbitTemplate rabbitTemplate){
        this.userRepository = userRepository;
        this.rabbitTemplate = rabbitTemplate;
    }
    @GetMapping("/index")
    public User getUser(@RequestParam int userId){
        rabbitTemplate.convertAndSend("spring-boot-exchange", "hien.pham.baz", "Hello from RabbitMQ!");
        System.out.println("the message is sent");
        return userRepository.findById(userId).orElse(null);
    }
}
