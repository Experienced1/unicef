package com.unicef.controller.noticeFaq.api;

import com.unicef.aop.annotation.LogAspect;
import com.unicef.aop.annotation.ValidAspect;
import com.unicef.dto.CMRespDto;
import com.unicef.dto.notice.NoticeModificationReqDto;
import com.unicef.dto.notice.NoticeReqDto;
import com.unicef.service.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/api/admin")
@RestController
@RequiredArgsConstructor
public class NoticeApi {

    private final NoticeService noticeService;

    @PostMapping("/notice")
    public ResponseEntity<?> submit(NoticeReqDto noticeReqDto) throws Exception {

        log.info("{}", noticeReqDto);
        noticeService.submit(noticeReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1, "공지사항 등록완료", noticeReqDto));
    }

    @GetMapping("/noticeList")
    public ResponseEntity<?> getNoticeList() throws Exception {
        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", noticeService.getNoticeList()));
    }

    @LogAspect
    @ValidAspect
    @PutMapping("/notice/modification")
    public ResponseEntity<?> updateNotice(@Valid @RequestBody NoticeModificationReqDto noticeModificationReqDto, BindingResult bindingResult) throws Exception {
        log.info("{}", noticeModificationReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", noticeService.updateNotice(noticeModificationReqDto)));
    }

    @DeleteMapping("/notice/{notice_id}")
    public ResponseEntity<?> deleteNotice(@PathVariable int notice_id) throws Exception {
        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", noticeService.deleteNotice(notice_id)));
    }
}
