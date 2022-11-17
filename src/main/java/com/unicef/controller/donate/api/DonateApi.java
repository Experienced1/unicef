package com.unicef.controller.donate.api;

import com.unicef.dto.donate.CMRespDto;
import com.unicef.dto.donate.DonateAreaReqDto;
import com.unicef.service.donate.DonateAreaService;
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
    private final DonateAreaService donateAreaService;

    @PostMapping("/donate/area")		//Json은 늘 @RequestBody가 따라와야한다
    public ResponseEntity<?> donateArea(@RequestBody DonateAreaReqDto donateAreaReqDto) throws Exception {
        log.info("{}", donateAreaReqDto);

        donateAreaService.donateArea(donateAreaReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1, "table4.후원분야", donateAreaReqDto));
    }

    @PostMapping("/donate")
    public ResponseEntity<?> donate(@RequestBody DonateAreaReqDto donateAreaReqDto) throws Exception {
        log.info("{}", donateAreaReqDto);

        donateAreaService.donateArea(donateAreaReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1, "table5.후원", donateAreaReqDto));
    }

}
