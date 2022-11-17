package com.unicef.controller.donate.api;

import com.unicef.dto.donate.CMRespDto;
import com.unicef.dto.donate.DonateReqDto;
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
public class DonateApi {
    private final DonateService donateAreaService;
    private final DonateService donateService;

    @PostMapping("/donate/area")
    public ResponseEntity<?> donateArea(@RequestBody DonateReqDto donateReqDto) throws Exception {
        log.info("{}", donateReqDto);

        donateAreaService.donate(donateReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1, "table4.후원분야", donateReqDto));
    }

    @PostMapping("/donate") //Json은 늘 @RequestBody가 따라와야한다
    public ResponseEntity<?> donate(@RequestBody DonateReqDto donateReqDto) throws Exception {
        log.info("{}", donateReqDto);

        donateService.donate(donateReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1, "table4.후원분야 성공, table5.후원 성공", donateReqDto));
    }

}
