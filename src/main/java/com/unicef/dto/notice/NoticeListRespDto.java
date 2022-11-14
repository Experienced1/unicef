package com.unicef.dto.notice;

import com.unicef.domain.NoticeImgFile;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data

public class NoticeListRespDto {

    private int noticeId;
    private String noticeTitle;
    private String noticeDetail;

    private List<NoticeImgFile> NoticeImgFile;


}
