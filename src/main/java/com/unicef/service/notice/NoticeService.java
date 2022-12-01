package com.unicef.service.notice;

import com.unicef.dto.notice.NoticeListRespDto;
import com.unicef.dto.notice.NoticeModificationReqDto;
import com.unicef.dto.notice.NoticeReqDto;

import java.util.List;

public interface NoticeService {

    public boolean submit(NoticeReqDto noticeReqDto) throws Exception;
    public List<NoticeListRespDto> getNoticeList() throws Exception;
    public boolean updateNotice(NoticeModificationReqDto noticeModificationReqDto) throws Exception;
    public boolean deleteNotice(int notice_id) throws Exception;
}
