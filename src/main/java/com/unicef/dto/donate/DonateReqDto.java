package com.unicef.dto.donate;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DonateReqDto {
    private int donateId;
    private String donateType;
    private int donateAmount;
    private int donateAreaId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
