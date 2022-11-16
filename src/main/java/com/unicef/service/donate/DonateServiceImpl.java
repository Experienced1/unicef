//package com.unicef.service.donate;
//
//import com.unicef.domain.Donate;
//import com.unicef.dto.donate.DonateReqDto;
//import com.unicef.repository.donate.DonateRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class DonateServiceImpl implements DonateService {
//    private final DonateRepository donateRepository;
//
//    @Override
//    public boolean donate(DonateReqDto donateReqDto) throws Exception {
//        Donate donateEntity = donateReqDto.toDonateEntity();
//        int result = donateRepository.donateInsert(donateEntity);
//
//        if(result == 0){ // 위에가 문제될 경우 resultCount가 0이되어 강제발생된다.
//            log.info("에러!!!!!!!!!!!!!!!!!!!! 페이지 만들어야함");
////            throw new CustomInternalServerErrorException("상품 등록 실패"); //e.getMessage가 상품등록실패뜸
//        }
//
//        return true;
//    }
//}
