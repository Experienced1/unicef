package com.unicef.controller.donate.api;

import com.unicef.dto.donate.CMRespDto;
import com.unicef.dto.donate.DonateReqDto;
import com.unicef.dto.donate.DonateRespDto;
import com.unicef.service.donate.DonateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class DonateApi {
    private final DonateService donateService;

    @PostMapping("/donate") //Json은 늘 @RequestBody가 따라와야한다
    public ResponseEntity<?> donate(@RequestBody DonateReqDto donateReqDto) throws Exception {
        log.info("[DonateApi] donateInfoData 데이터: {}", donateReqDto);
        // donateReqDto: DonateReqDto(donateAreaId=0, donateName=김이름, donateArea=난민 어린이 돕기, donateAmount=100, donateType=정기후원)

        donateService.donate(donateReqDto);

        return ResponseEntity.ok(new CMRespDto<>(1, "table4.후원분야 성공, table5.후원 성공", donateReqDto));
    }

    @GetMapping("/mypage/supportinfo/mylist/{userId}")
    public ResponseEntity<?> getDonateList(@PathVariable int userId) throws Exception {
        List<DonateRespDto> list = new ArrayList<DonateRespDto>();
        list = donateService.getDonateList(userId);

//        log.info("[DonateApi] donateInfoData 데이터: {}", list);
        return ResponseEntity.ok(new com.unicef.dto.CMRespDto<>(1, "myList 정보", list));
    }

    @DeleteMapping("/mypage/supportinfo/mylist/{donateId}")
    public ResponseEntity<?> deleteDonate(@PathVariable int donateId) throws Exception{
        return ResponseEntity.ok(new com.unicef.dto.CMRespDto<>(1, "후원내역 삭제", donateService.deleteDonate(donateId)));
    }

}
