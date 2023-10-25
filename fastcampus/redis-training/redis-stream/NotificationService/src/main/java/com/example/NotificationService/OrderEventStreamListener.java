package com.example.NotificationService;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class OrderEventStreamListener implements StreamListener<String, MapRecord<String, String, String>> {

    @Override
    public void onMessage(final MapRecord<String, String, String> message) {
        final Map<String, String> map = message.getValue();

        final String userId = map.get("userId");
        final String productId = map.get("productId");

        // 주문 건에 대한 메일 발송 처리
        System.out.println("[Order consumed] userId: " + userId + " productId: " + productId);
    }
}
