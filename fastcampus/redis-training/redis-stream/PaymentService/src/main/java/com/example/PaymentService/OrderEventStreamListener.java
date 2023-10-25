package com.example.PaymentService;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventStreamListener implements
    StreamListener<String, MapRecord<String, String, String>> {

    @Autowired
    private StringRedisTemplate redisTemplate;
    private int paymentProcessId = 0;

    @Override
    public void onMessage(final MapRecord<String, String, String> message) {
        final Map<String, String> map = message.getValue();

        final String userId = map.get("userId");
        final String productId = map.get("productId");
        final String price = map.get("price");

        // 결제 관련 로직 처리
        // ...

        final String paymentIdStr = Integer.toString(paymentProcessId++);

        // 결제 완료 이벤트 발행
        final Map<String, String> fieldMap = new HashMap<>();
        fieldMap.put("userId", userId);
        fieldMap.put("productId", productId);
        fieldMap.put("price", price);
        fieldMap.put("paymentProcessId", paymentIdStr);

        redisTemplate.opsForStream().add("payment-events", fieldMap);

        System.out.println("[Order consumed] Created payment: " + paymentIdStr);
    }
}
