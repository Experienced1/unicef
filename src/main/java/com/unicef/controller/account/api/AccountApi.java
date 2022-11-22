package com.unicef.controller.account.api;


import com.unicef.aop.annotation.LogAspect;
import com.unicef.aop.annotation.ValidAspect;
import com.unicef.dto.CMRespDto;
import com.unicef.dto.account.JoinReqDto;
import com.unicef.dto.validation.ValidationSequence;
import com.unicef.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @LogAspect
    @ValidAspect
    @PostMapping("/join/form")
    public ResponseEntity<?> join(@Validated(ValidationSequence.class) @RequestBody JoinReqDto joinReqDto, BindingResult bindingResult) {

        accountService.checkDuplicateId(joinReqDto.getUserId());

        return ResponseEntity.ok().body(null);
    }


}
