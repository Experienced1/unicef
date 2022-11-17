//package com.unicef.dto.donate;
//
//import com.unicef.domain.Donate;
//import com.unicef.domain.DonateArea;
//import lombok.Data;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Options;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import java.io.InputStream;
//import java.time.LocalDateTime;
//
//@Data
//public class DonateReqDto {
//    private String donateType;
//    private int donateAmount;
//    private int donateAreaId;
//
//    public Donate toDonateEntity(int donate_area_id){
//
//
//        Donate.builder()
//                .donate_type(donateType)
//                .donate_amount(donateAmount)
//                .donate_area_id(donateAreaId)
//                .donate_area(donate_area_id);
//                .build();
//
//        return Donate
//
//    }
//}
