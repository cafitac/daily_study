package com.example.checkout;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CheckOutDto {

    private Long checkOutId;
    private Long memberId;
    private Long productId;
    private Long amount;
    private String shippingAddress;
    private Date createdAt;
}
