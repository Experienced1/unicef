package com.unicef.controller.noticeFaq.api;

import com.unicef.dto.CMRespDto;
import com.unicef.dto.faq.FaqReqDto;
import com.unicef.service.faq.FaqService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/admin")
@RestController
@RequiredArgsConstructor
public class FaqApi {

    private final FaqService faqService;

    @PostMapping("/faq")
    public ResponseEntity<?> submit(FaqReqDto faqReqDto) throws Exception {

        log.info("{}", faqReqDto);
        faqService.submit(faqReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1, "FAQ 등록완료", faqReqDto));
    }

    @GetMapping("/faqList")
    public ResponseEntity<?> getFaqList() throws Exception {

        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", faqService.getFaqList()));
    }
}
