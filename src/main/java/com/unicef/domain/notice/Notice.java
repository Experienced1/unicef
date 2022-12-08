package com.unicef.domain.notice;

import com.unicef.dto.notice.NoticeListRespDto;
import com.unicef.dto.notice.NoticeWriteRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notice {
    private int notice_id;
    private String notice_title;
    private String notice_detail;

    private LocalDateTime create_date;
    private LocalDateTime update_date;

    private List<AttachedFile> attached_file;

    public NoticeListRespDto toListRespDto(){
        return NoticeListRespDto.builder()
                .notice_id(notice_id)
                .notice_title(notice_title)
                .notice_detail(notice_detail)
                .create_date(create_date.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")))
//                .update_date(update_date.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")))
//                .create_date(create_date)
//                .update_date(update_date)
                .attachedFileList(attached_file)
                .build();
    }

    public NoticeWriteRespDto toNoticeWriteRespDto(List<AttachedFile> attachedFileList){
        return NoticeWriteRespDto.builder()
                .notice_id(notice_id)
                .notice_title(notice_title)
                .notice_detail(notice_detail)
//                .create_date(create_date.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")))
//                .update_date(update_date.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")))
//                .create_date(create_date)
//                .update_date(update_date)
                .attachedFileList(attachedFileList)
                .build();
    }
}
