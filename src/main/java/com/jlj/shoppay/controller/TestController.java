package com.jlj.shoppay.controller;

import org.springframework.data.redis.core.RedisTemplate;

public class TestController {
    public static void main(String[] args) {
        RedisTemplate redisTemplate=new RedisTemplate();
        redisTemplate.opsForValue().set("k","24");
        System.out.println("success");
    }
}
