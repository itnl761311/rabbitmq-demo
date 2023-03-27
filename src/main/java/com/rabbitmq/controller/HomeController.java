package com.rabbitmq.controller;

import com.rabbitmq.dto.UserDto;
import com.rabbitmq.entity.User;
import com.rabbitmq.rabbitmqConfig.ConfigRabbitMq;
import com.rabbitmq.rabbitmqConfig.Publisher;
import com.rabbitmq.service.IUserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {
    IUserService userService;
    RabbitTemplate rabbitTemplate;
    ConfigRabbitMq ConfigRabbitMq;
    public HomeController(IUserService userService, RabbitTemplate rabbitTemplate, ConfigRabbitMq ConfigRabbitMq){
        this.userService = userService;
        this.rabbitTemplate = rabbitTemplate;
        this.ConfigRabbitMq = ConfigRabbitMq;
    }
//    @GetMapping("/index")
//    public User getUser(@RequestParam int userId){
//        Publisher p = new Publisher(rabbitTemplate);
//        p.userLogin("");
//        System.out.println("the message is sent");
//        return userRepository.findById(userId).orElse(null);
//    }
    @PostMapping("/get")
    public User get(@RequestBody UserDto userDto){
        User user = userService.getUserByEmail(userDto.getEmail());
        if(user != null){
            Publisher p = new Publisher(rabbitTemplate);
            p.getUser(user);
        }
        return user;
    }
}
