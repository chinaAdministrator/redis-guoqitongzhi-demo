package com.example.redisguoqitongzhidemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 测试controller
 */
@RestController
public class TestController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping
    public String hello() {
        return "success";
    }

    @RequestMapping("/test")
    public Object test(String name) {
        stringRedisTemplate.opsForValue().set(name, "name", 10, TimeUnit.SECONDS);
        return null;
    }
}