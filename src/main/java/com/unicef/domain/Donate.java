package com.unicef.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Donate {
    private int donate_id;
    private String donate_type;
    private int donate_amount;
    private int donate_area_id;
    private DonateArea donate_area; //Join용도
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
