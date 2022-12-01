package com.unicef.domain;

import com.unicef.dto.notice.NoticeListRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notice {
    private int notice_id;
    private String notice_title;
    private int img_id;
    private String notice_detail;

    private LocalDateTime create_date;
    private LocalDateTime update_date;

    public NoticeListRespDto toListRespDto(){
        return NoticeListRespDto.builder()
                .notice_id(notice_id)
                .notice_title(notice_title)
                .img_id(img_id)
                .notice_detail(notice_detail)
                .update_date(update_date)
                .build();
    }

}
