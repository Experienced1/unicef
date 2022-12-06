package com.unicef.domain.donate;

import com.unicef.dto.donate.DonateRespDto;
import com.unicef.dto.user.UserRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Donate {
    private int donate_id;
    private int user_id;
    private String donate_area;
    private String donate_type;
    private int donate_amount;
    private int donate_area_id;
    private LocalDateTime create_date;
    private LocalDateTime update_date;


    public DonateRespDto getDonateEntity(){
        return DonateRespDto.builder()
                .donateId(donate_id)
                .userId(user_id)
                .donateType(donate_type)
                .donateArea(donate_area)
                .donateAmount(donate_amount)
                .createDate(create_date)
                .build();
    }
}
