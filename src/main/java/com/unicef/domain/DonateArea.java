package com.unicef.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class DonateArea {
    private int donate_area_id;
    private String donate_name;
    private String donate_area;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
