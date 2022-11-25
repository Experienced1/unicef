package com.unicef.service.mypage;

import com.unicef.domain.Onetoone;
import com.unicef.dto.mypage.OnetooneReqDto;
import com.unicef.repository.mypage.OnetooneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class OnetooneServiceImpl implements OnetooneService{

    private final OnetooneRepository onetooneRepository;

    @Override
    public boolean submit(OnetooneReqDto onetooneReqDto) throws Exception {
        int resultCount;

        Onetoone onetoone = onetooneReqDto.toOnetooneEntity();

        resultCount = onetooneRepository.save(onetoone);

        if(resultCount == 0){
            log.info("에러발생");
        }
        return false;
    }
}
