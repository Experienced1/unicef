package com.unicef.domain.donate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Donate {
    private int donate_id;
    private String donate_name;
    private String donate_area;
    private String donate_type;
    private int donate_amount;
    private int donate_area_id;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
