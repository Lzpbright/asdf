package com.test.login.mapper;

public interface UserMapper {
    String login(String account, String password);
    long register(String account, String name, String password);
}
