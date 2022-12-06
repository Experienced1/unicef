package com.unicef.dto.donate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DonateRespDto {
    private int donateId;
    private int userId;

    private String donateArea;
    private String donateType;
    private int donateAmount;
    private LocalDateTime createDate;

}
