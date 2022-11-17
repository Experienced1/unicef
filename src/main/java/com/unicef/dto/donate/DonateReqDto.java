package com.unicef.dto.donate;

import com.unicef.domain.Donate;
import com.unicef.domain.DonateArea;
import lombok.Data;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.time.LocalDateTime;

@Data
public class DonateReqDto {
    private int donateAreaId;
    private String donateName;
    private String donateArea;
    private int donateAmount;
    private String donateType;

    public DonateArea toDonateAreaEntity(){ // table4 후원분야
        return DonateArea.builder()
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
