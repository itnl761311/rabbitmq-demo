package com.rabbitmq.service;

import com.rabbitmq.entity.User;

public interface IUserService {
    User getUserByEmail(String email);
}
