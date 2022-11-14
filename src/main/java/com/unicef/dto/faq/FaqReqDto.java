package com.unicef.dto.faq;

import lombok.Data;

@Data
public class FaqReqDto {

    private int faq_id;
    private String faq_writer;
    private int category_id;
    private String faq_title;
    private String faq_detail;
}
