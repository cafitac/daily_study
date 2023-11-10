package com.fastcampus.helloecommeradmin.service.dto;

import com.fastcampus.helloecommeradmin.enums.OrderStatus;
import com.fastcampus.helloecommeradmin.enums.PayType;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.Data;

@Data(staticConstructor = "of")
public class OrderDTO {

    private final Long orderId;
    private final BigDecimal amount;
    private final Long customerId;
    private final String customerName;
    private final PayType payType;
    private final OrderStatus orderStatus;
    private final OffsetDateTime orderDate;
}