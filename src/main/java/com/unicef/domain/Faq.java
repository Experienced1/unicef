package com.unicef.domain;

import com.unicef.dto.faq.FaqListRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Faq {
    private int faq_id;
    private String category;
    private String faq_title;
    private String faq_detail;

    private LocalDateTime create_date;
    private LocalDateTime update_date;

    public FaqListRespDto toListRespDto() {
        return FaqListRespDto.builder()
                .id(faq_id)
                .category(category)
                .faq_title(faq_title)
                .faq_detail(faq_detail)
                .build();
    }
}
