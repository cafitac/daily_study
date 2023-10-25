package com.example.NotificationService;

import java.util.Map;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventStreamListener implements StreamListener<String, MapRecord<String, String, String>> {

    @Override
    public void onMessage(final MapRecord<String, String, String> message) {
        final Map<String, String> map = message.getValue();

        final String userId = map.get("userId");
        final String paymentProcessId = map.get("paymentProcessId");

        // 결제 완료 건에 대한 SMS 발송 처리
        System.out.println("[Payment consumed] userId: " + userId + " paymentProcessId: " + paymentProcessId);
    }
}
