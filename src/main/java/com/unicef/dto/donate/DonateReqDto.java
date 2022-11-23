package com.unicef.dto.donate;

import com.unicef.domain.donate.Donate;
import lombok.Data;

@Data
public class DonateReqDto {
    private int donateAreaId;
    private String donateName;
    private String donateArea;
    private int donateAmount;
    private String donateType;

    public Donate toDonateAreaEntity(){ // table4 후원분야
        return Donate.builder()
                .donate_name(donateName)
                .donate_area(donateArea)
                .build();
    }

    public Donate toDonateEntity(){ // table5 후원
        return Donate.builder()
                .donate_type(donateType)
                .donate_amount(donateAmount)
                .donate_area_id(donateAreaId)
                .build();
    }
}
