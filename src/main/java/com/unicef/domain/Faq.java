package com.unicef.domain;

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
    private String faq_writer;
    private int category_id;
    private Category category;
    private String faq_title;
    private String faq_detail;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
}
