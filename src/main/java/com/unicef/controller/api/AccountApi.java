package com.unicef.controller.api;


import com.unicef.dto.account.CMRespDto;
import com.unicef.dto.account.JoinReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/api/account")
@RestController
public class AccountApi {

    @PostMapping("/join/form")
    public ResponseEntity<?> join(@Valid @RequestBody JoinReqDto joinReqDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            log.error("유효성 검사 오류가 발생");
            Map<String, String> errorMap = new HashMap<String, String>();

            bindingResult.getFieldErrors().forEach(error -> {
               log.info("Error: 코드({}), Error: 필드명({}), 메세지({})", error.getCode(), error.getField(), error.getDefaultMessage());
               if(!error.getCode().equals("NotBlank")) {
                    errorMap.put(error.getField(), error.getDefaultMessage());

               }
            });
            bindingResult.getFieldErrors().forEach(error -> {
                log.info("Error: 코드({}), Error: 필드명({}), 메세지({})", error.getCode(), error.getField(), error.getDefaultMessage());
                if(error.getCode().equals("NotBlank")) {
                    errorMap.put(error.getField(), error.getDefaultMessage());

                }
            });
            return ResponseEntity.badRequest().body(new CMRespDto<>(-1,"유효성 검사 실패", errorMap));
        }

        log.info("{}", joinReqDto);

        return ResponseEntity.ok(null);
    }

}
