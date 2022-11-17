package com.unicef.dto.mypage;

import com.unicef.domain.Onetoone;
import lombok.Data;

@Data
public class OnetooneReqDto {

    private String category;
    private String title;
    private String detail;

    public Onetoone toOnetooneEntity(){
        return Onetoone.builder()
                .category(category)
                .title(title)
                .detail(detail)
                .build();
    }
}
