package com.unicef.dto.notice;

import com.unicef.domain.notice.AttachedFile;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class NoticeListRespDto {
    private int notice_id;
    private String notice_title;
    private String notice_detail;
    private String update_date;

    private List<AttachedFile> attachedFileList;
}
