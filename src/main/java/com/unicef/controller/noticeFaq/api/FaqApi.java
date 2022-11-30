package com.unicef.controller.noticeFaq.api;

import com.unicef.aop.annotation.LogAspect;
import com.unicef.aop.annotation.ValidAspect;
import com.unicef.dto.CMRespDto;
import com.unicef.dto.faq.FaqModificationReqDto;
import com.unicef.dto.faq.FaqReqDto;
import com.unicef.service.faq.FaqService;
import lombok.Getter;
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

    @LogAspect
    @ValidAspect
    @PutMapping("/faq/modification")
    public ResponseEntity<?> updateFaq(@Valid @RequestBody FaqModificationReqDto faqModificationReqDto, BindingResult bindingResult) throws Exception {
        System.out.println(faqModificationReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", faqService.updateFaq(faqModificationReqDto)));
    }

    @DeleteMapping("/faq/{id}")
    public ResponseEntity<?> deleteFaq(@PathVariable int id) throws Exception{
        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", faqService.deleteFaq(id)));
    }
}
