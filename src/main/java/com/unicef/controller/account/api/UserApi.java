package com.unicef.controller.account.api;

import com.unicef.aop.annotation.ValidAspect;
import com.unicef.dto.account.UserReqDto;
import com.unicef.dto.donate.CMRespDto;
import com.unicef.service.account.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class UserApi {
    private final UserService userService;



    @ValidAspect
    @PostMapping("/account/joinform") //Json은 늘 @RequestBody가 따라와야한다
    public ResponseEntity<?> joinform(@Valid @RequestBody UserReqDto userReqDto,
                                       BindingResult bindingResult) throws Exception {

        log.info("userInfoData 데이터: {}", userReqDto);

        userService.checkDuplicateMainUsername(userReqDto.getMainUsername());
        userService.user(userReqDto);

        return ResponseEntity.ok(new CMRespDto<>(1, "table2.사용자 성공", userReqDto));
    }
}
