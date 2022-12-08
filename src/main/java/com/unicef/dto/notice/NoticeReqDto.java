package com.unicef.dto.notice;

import com.unicef.domain.notice.AttachedFile;
import com.unicef.domain.notice.Notice;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class NoticeReqDto {
    private int notice_id;
    @NotBlank(message = "빈 값일 수 없습니다")
    private String notice_title;
    @NotBlank(message = "빈 값일 수 없습니다")
    private String notice_detail;

    private List<AttachedFile> files;

    private LocalDateTime create_date;
    private LocalDateTime update_date;

    public Notice toNoticeEntity(){
        return Notice.builder()
                .notice_id(notice_id)
                .notice_title(notice_title)
                .notice_detail(notice_detail)
                .create_date(create_date)
                .update_date(update_date)
                .attached_file(files)
                .build();
    }

}
