package com.unicef.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Notice {

    private int noticeId;
    private String noticeTitle;
    private String noticeDetail;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
}
