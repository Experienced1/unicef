package com.unicef.dto.notice;

import com.unicef.domain.notice.Notice;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class NoticeModificationReqDto {
    private int notice_id;
    @NotBlank(message = "빈 값일 수 없습니다")
    private String notice_title;
    @NotBlank(message = "빈 값일 수 없습니다")
    private String notice_detail;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

    public Notice toNoticeEntity(){
        return Notice.builder()
                .notice_id(notice_id)
                .notice_title(notice_title)
                .notice_detail(notice_detail)
                .create_date(create_date)
                .update_date(update_date)
                .build();
    }
}
