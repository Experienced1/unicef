package com.unicef.service.notice;

import com.unicef.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class  NoticeServiceImpl{

    private final NoticeRepository noticeRepository;

}
