package com.unicef.dto.notice;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class NoticeListRespDto {
    private int notice_id;
    private String notice_title;
    private int img_id;
    private String notice_detail;
    private LocalDateTime update_date;
}
