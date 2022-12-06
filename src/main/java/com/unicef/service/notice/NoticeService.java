package com.unicef.service.notice;

import com.unicef.dto.notice.*;

import java.util.List;

public interface NoticeService {

    public int submit(NoticeWriteReqDto noticeWriteReqDto) throws Exception;
    public List<NoticeListRespDto> getNoticeList() throws Exception;
    public boolean updateNotice(NoticeModificationReqDto noticeModificationReqDto) throws Exception;
    public boolean deleteNotice(int notice_id) throws Exception;
}
