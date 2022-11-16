package com.unicef.dto.donate;

import com.unicef.domain.DonateArea;
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
