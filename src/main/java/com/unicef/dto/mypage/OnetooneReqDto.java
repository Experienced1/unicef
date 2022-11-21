package com.unicef.dto.mypage;

import com.unicef.domain.Onetoone;
import lombok.Data;

@Data
public class OnetooneReqDto {
    private int onetoone_id;
    private String onetoone_writer;
    private String category;
    private String title;
    private String detail;

    public Onetoone toOnetooneEntity(){

        return Onetoone.builder()
                .onetoone_id(onetoone_id)
                .onetoone_writer(onetoone_writer)
                .category(category)
                .title(title)
                .detail(detail)
                .build();
    }
}
