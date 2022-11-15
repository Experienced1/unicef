package com.unicef.repository.donate;

import com.unicef.domain.Donate;
import com.unicef.domain.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentRepository {
    public int paymentInsert(Payment payment);
}
