package com.example.OrderService;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/order")
    public String order(
        @RequestParam String userId,
        @RequestParam String productId,
        @RequestParam String price
    ) {
        final Map<String, String> fieldMap = new HashMap<>();
        fieldMap.put("userId", userId);
        fieldMap.put("productId", productId);
        fieldMap.put("price", price);

        redisTemplate.opsForStream().add("order-events", fieldMap);

        System.out.println("Order created");
        return "ok";
    }
}
