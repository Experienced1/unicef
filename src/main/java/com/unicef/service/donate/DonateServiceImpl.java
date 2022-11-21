package com.unicef.service.donate;

import com.unicef.domain.Donate;
import com.unicef.dto.donate.DonateReqDto;
import com.unicef.repository.donate.DonateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DonateServiceImpl implements DonateService {
    private final DonateRepository donateAreaData;
    private final DonateRepository donateData;

    @Override
    public boolean donate(DonateReqDto donateReqDto) throws Exception {
        // table4
        Donate donateAreaEntity = donateReqDto.toDonateAreaEntity();
        log.info("4번 테이블: {}", donateAreaEntity);
        int result4 = donateAreaData.donateAreaInsert(donateAreaEntity);

        if(result4 == 0){ // 위에가 문제될 경우 resultCount가 0이되어 강제발생된다.
            log.info("에러4!!!!!!!!!!!!!!!!!!!! 페이지 만들어야함");
//            throw new CustomInternalServerErrorException("상품 등록 실패"); //e.getMessage가 상품등록실패뜸
        }

        // table3
        Donate donateEntity = donateReqDto.toDonateEntity();
        Donate donateEntityData = Donate.builder()
                .donate_type(donateEntity.getDonate_type())
                .donate_amount(donateEntity.getDonate_amount())
                .donate_area_id(donateAreaEntity.getDonate_area_id()) // 현재 table4의 id값
                .build();

        log.info("5번 테이블: {}", donateEntityData);
        int result3 = donateData.donateInsert(donateEntityData);

        if(result3 == 0){ // 위에가 문제될 경우 resultCount가 0이되어 강제발생된다.
            log.info("에러3!!!!!!!!!!!!!!!!!!!! 페이지 만들어야함");
//            throw new CustomInternalServerErrorException("상품 등록 실패"); //e.getMessage가 상품등록실패뜸
        }

        return false;
    }
}
