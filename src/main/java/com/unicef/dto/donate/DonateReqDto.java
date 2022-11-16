//package com.unicef.dto.donate;
//
//import com.unicef.domain.Donate;
//import com.unicef.domain.DonateArea;
//import lombok.Data;
//import java.time.LocalDateTime;
//
//@Data
//public class DonateReqDto {
//    private String donateType;
//    private int donateAmount;
//    private int donateAreaId;
//
//    public Donate toDonateEntity(){
//        return Donate.builder()
//                .donate_type(donateType)
//                .donate_amount(donateAmount)
//                .donate_area_id(donateAreaId)
//                .(donate_area)
//                .build();
//    }
//}
