package com.unicef.dto.donate;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentReqDto {
    private int paymentId;
    private int donateId;
    private int paymentName;
    private String paymentMethod;
    private String paymentInfo;
}
