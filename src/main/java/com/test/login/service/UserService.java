package com.test.login.service;

import com.test.login.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    public String login(String account, String password){
        return userMapper.login(account, password);
    }

    public long register(String account, String name, String password){
        return userMapper.register(account, name, password);
    }
}
