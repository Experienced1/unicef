package com.unicef.dto.donate;

import com.unicef.domain.donate.Donate;
import lombok.Data;
import org.apache.catalina.User;

@Data
public class DonateReqDto {
    private int userId;
    private int donateAreaId;
    private String donateArea;
    private int donateAmount;
    private String donateType;

    public Donate toDonateAreaEntity(){ // table4 후원분야
        return Donate.builder()
                .donate_area(donateArea)
                .build();
    }

    public Donate toDonateEntity(){ // table5 후원
        return Donate.builder()
                .user_id(userId)
                .donate_type(donateType)
                .donate_amount(donateAmount)
                .donate_area_id(donateAreaId)
                .build();
    }
}
