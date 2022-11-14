package com.unicef.dto.donate;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DonateAreaReqDto {
    private int donateAreaId;
    private int donateName;
    private String donateArea;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
