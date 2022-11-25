package com.unicef.controller.mypage.api;

import com.unicef.dto.CMRespDto;
import com.unicef.dto.mypage.OnetooneReqDto;
import com.unicef.service.mypage.OnetooneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class OnetooneApi {

    private final OnetooneService onetooneService;


    @PostMapping("/mypage/onetoone")
    public ResponseEntity<?> submit(OnetooneReqDto onetooneReqDto) throws Exception{
        log.info("{}", onetooneReqDto);

        onetooneService.submit(onetooneReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1, "문의 제출완료", onetooneReqDto));
    }
}
