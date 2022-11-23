package com.unicef.controller.account.api;

import com.unicef.dto.account.UserReqDto;
import com.unicef.dto.donate.CMRespDto;
import com.unicef.dto.donate.DonateReqDto;
import com.unicef.service.account.UserService;
import com.unicef.service.donate.DonateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class UsertApi {
    private final UserService userService;

    @PostMapping("/account/joinform") //Json은 늘 @RequestBody가 따라와야한다
    public ResponseEntity<?> donate(@RequestBody UserReqDto userReqDto) throws Exception {
        log.info("userInfoData 데이터: {}", userReqDto);
        // donateReqDto: DonateReqDto(donateAreaId=0, donateName=김이름, donateArea=난민 어린이 돕기, donateAmount=100, donateType=정기후원)

        userService.user(userReqDto);

        return ResponseEntity.ok(new CMRespDto<>(1, "table2.사용자 성공", userReqDto));
    }

}
