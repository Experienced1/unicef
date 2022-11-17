package com.unicef.controller.mypage.api;

import com.unicef.dto.CMRespDto;
import com.unicef.dto.mypage.OnetooneReqDto;
import com.unicef.service.mypage.OnetooneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/mypage")
@RestController
@RequiredArgsConstructor
public class OnetooneApi {

    private final OnetooneService onetooneService;


    @PostMapping("/onetoone")
    public ResponseEntity<?> submit(OnetooneReqDto onetooneReqDto, BindingResult bindingResult) throws Exception{
        return ResponseEntity
                .created(null)
                .body(new CMRespDto<>(1, "Successfully submitted", onetooneService.submit(onetooneReqDto)));
    }
}
