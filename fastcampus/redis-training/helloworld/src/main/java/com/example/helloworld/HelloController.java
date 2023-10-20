package com.example.helloworld;

import io.netty.util.internal.SuppressJava6Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/setFruit")
    public String setFruit(@RequestParam String name) {
        final ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("fruit", name);

        return "saved";
    }

    @GetMapping("/getFruit")
    public String setFruit() {
        final ValueOperations<String, String> ops = redisTemplate.opsForValue();
        final String fruitName = ops.get("fruit");

        return fruitName;
    }
}
