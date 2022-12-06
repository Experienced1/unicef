package com.unicef.service.notice;

import com.unicef.domain.notice.Notice;
import com.unicef.dto.notice.NoticeListRespDto;
import com.unicef.dto.notice.NoticeModificationReqDto;
import com.unicef.dto.notice.NoticeReqDto;
import com.unicef.dto.notice.NoticeWriteReqDto;
import com.unicef.repository.notice.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{

    private final NoticeRepository noticeRepository;

    @Override
    public int submit(NoticeWriteReqDto noticeWriteReqDto) throws Exception {
        int result;

        Notice notice = noticeWriteReqDto.toEntity();

        result = noticeRepository.save(notice);

        if(result == 0){
            log.info("에러발생");
        }
        return notice.getNotice_id();
    }

    @Override
    public List<NoticeListRespDto> getNoticeList() throws Exception {
        Map<String, Object> paramsMap = new HashMap<String, Object>();

        List<NoticeListRespDto> list = new ArrayList<NoticeListRespDto>();

        noticeRepository.getNoticeList(paramsMap).forEach(notice -> {
            list.add(notice.toListRespDto());
        });
        return list;
    }

    @Override
    public boolean updateNotice(NoticeModificationReqDto noticeModificationReqDto) throws Exception {
        boolean status;

        status = noticeRepository.setNotice(noticeModificationReqDto.toNoticeEntity()) > 0;

        if(!status) {
            log.info("error!!");
        }
        return status;
    }

    @Override
    public boolean deleteNotice(int notice_id) throws Exception {
        if(noticeRepository.deleteNotice(notice_id) > 0){
            return true;
        }
        return false;
    }
}
