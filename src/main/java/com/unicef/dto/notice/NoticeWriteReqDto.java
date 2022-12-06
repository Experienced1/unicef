package com.unicef.dto.notice;

import com.unicef.domain.notice.Notice;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class NoticeWriteReqDto {
    private int notice_id;
    private String notice_title;
    private String notice_detail;
    private List<MultipartFile> attachedFiles;

    private LocalDateTime update_date;
    public Notice toEntity(){
        return Notice.builder()
                .notice_id(notice_id)
                .notice_title(notice_title)
                .notice_detail(notice_detail)
                .update_date(update_date)
                .build();
    }
}
