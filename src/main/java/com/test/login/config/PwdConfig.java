package com.test.login.config;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Component
public class PwdConfig {

    public String encode(CharSequence rawPassword) {
        // md5加密
        return DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
    }
}