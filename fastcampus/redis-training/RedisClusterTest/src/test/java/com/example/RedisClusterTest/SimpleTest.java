package com.example.RedisClusterTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class SimpleTest {

    @Autowired
    private RedisTemplate redisTemplate;
    private String dummyValue = "banana";

    @Test
    void setValue() {
        final ValueOperations<String, String> ops = redisTemplate.opsForValue();

        for (int i = 0; i < 1000; i++) {
            final String key = String.format("name:%d", i);
            ops.set(key, dummyValue);
        }
    }

    @Test
    void getValues() {
        final ValueOperations<String, String> ops = redisTemplate.opsForValue();

        for (int i = 0; i < 1000; i++) {
            final String key = String.format("name:%d", i);
            final String value = ops.get(key);

            assertThat(value).isEqualTo(dummyValue);
        }
    }
}
