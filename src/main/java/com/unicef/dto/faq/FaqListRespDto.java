package com.unicef.dto.faq;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FaqListRespDto {
    private int id;
    private String category;
    private String faq_title;
    private String faq_detail;
}
