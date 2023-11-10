package com.fastcampus.helloecommeradmin.domain.order;

import com.fastcampus.helloecommeradmin.enums.OrderStatus;
import com.fastcampus.helloecommeradmin.enums.PayType;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetailView {

    private Long orderId;
    private Long customerId;
    private String customerName;
    private BigDecimal amount;
    private OrderStatus orderStatus;
    private PayType payType;
    private OffsetDateTime createdAt;
}