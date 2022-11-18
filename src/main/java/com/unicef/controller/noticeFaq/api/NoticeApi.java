package com.unicef.controller.noticeFaq.api;

import com.unicef.dto.notice.NoticeReqDto;
import com.unicef.service.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/admin")
@RestController
@RequiredArgsConstructor

public class NoticeApi {

    private final NoticeService noticeService;

//    공지사항 게시글 등록
    @PostMapping("/notice")
    public ResponseEntity<?> notice(@RequestBody NoticeReqDto noticeListReqDto){
        log.info("{}", noticeListReqDto);
        return  ResponseEntity.ok(null);
    }






}
