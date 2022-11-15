package com.unicef.dto.donate;

import com.unicef.domain.DonateArea;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DonateAreaReqDto {
//    private int donateAreaId;
    private String donateName;
    private String donateArea;

    public DonateArea toDonateAreaEntity(){
        return DonateArea.builder()
//                .donate_area_id(donateAreaId)
                .donate_name(donateName)
                .donate_area(donateArea)
                .build();
    }
}
