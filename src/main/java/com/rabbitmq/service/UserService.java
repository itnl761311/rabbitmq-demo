package com.rabbitmq.service;

import com.rabbitmq.entity.User;
import com.rabbitmq.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElse(null);
    }
}
