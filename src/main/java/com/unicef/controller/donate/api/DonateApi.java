package com.unicef.controller.donate.api;

import com.unicef.dto.donate.CMRespDto;
import com.unicef.dto.donate.DonateAreaReqDto;
import com.unicef.service.donate.DonateAreaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DonateApi {
    private final DonateAreaService donateAreaService;

    @PostMapping("/donate/area")		//Json은 늘 @RequestBody가 따라와야한다
    public ResponseEntity<?> donateArea(@RequestBody DonateAreaReqDto donateAreaReqDto) throws Exception {
        log.info("{}", donateAreaReqDto);

//        donateAreaService.donateArea(donateAreaReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1, "table4.후원분야", donateAreaReqDto));
    }

}
