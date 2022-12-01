package com.unicef.dto.notice;

import com.unicef.domain.Notice;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class NoticeReqDto {
    private int notice_id;
    @NotBlank(message = "빈 값일 수 없습니다")
    private String notice_title;
    private int img_id;
    @NotBlank(message = "빈 값일 수 없습니다")
    private String notice_detail;

    private LocalDateTime update_date;

    public Notice toNoticeEntity(){
        return Notice.builder()
                .notice_id(notice_id)
                .notice_title(notice_title)
                .img_id(img_id)
                .notice_detail(notice_detail)
                .update_date(update_date)
                .build();
    }

}
