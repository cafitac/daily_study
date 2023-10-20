package com.example.RedisCaching.service;

import com.example.RedisCaching.dto.UserProfile;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ExternalApiService externalApiService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    public UserProfile getUserProfile(String userId) {
        String userName;

        final ValueOperations<String, String> ops = redisTemplate.opsForValue();
        final String cachedName = ops.get("nameKey:" + userId);

        if (cachedName != null) {
            userName = cachedName;
        } else {
            userName = externalApiService.getUserName(userId);
            ops.set("nameKey:" + userId, userName, 5, TimeUnit.SECONDS);
        }
        int userAge = externalApiService.getUserAge(userId);

        return new UserProfile(userName, userAge);
    }
}
