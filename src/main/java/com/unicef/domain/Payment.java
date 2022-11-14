package com.unicef.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Payment {
    private int payment_id;
    private int donate_id;
    private Donate donate;
    private int payment_name;
    private String payment_method;
    private String payment_info;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
