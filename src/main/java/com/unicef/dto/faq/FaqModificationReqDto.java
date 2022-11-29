package com.unicef.dto.faq;

import com.unicef.domain.Faq;
import com.unicef.dto.validation.ValidationGroups;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FaqModificationReqDto {
    private int id;
    @NotBlank(message = "빈 값일 수 없습니다")
    private String category;
    @NotBlank(message = "빈 값일 수 없습니다")
    private String faq_title;
    @NotBlank(message = "빈 값일 수 없습니다")
    private String faq_detail;

    public Faq toFaqEntity(){
        return Faq.builder()
                .faq_id(id)
                .category(category)
                .faq_title(faq_title)
                .faq_detail(faq_detail)
                .build();
    }
}
