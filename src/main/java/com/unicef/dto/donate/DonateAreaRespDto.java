package com.unicef.dto.donate;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DonateAreaRespDto {
    private int donateAreaId;
    private String donateName;
    private String donateArea;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
