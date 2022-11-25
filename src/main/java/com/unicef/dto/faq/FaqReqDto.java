package com.unicef.dto.faq;

import com.unicef.domain.Faq;
import lombok.Data;

@Data
public class FaqReqDto {

    private int faq_id;
    private String category;
    private String faq_title;
    private String faq_detail;

    public Faq toFaqEntity(){
        return Faq.builder()
                .faq_id(faq_id)
                .category(category)
                .faq_title(faq_title)
                .faq_detail(faq_detail)
                .build();
    }
}
