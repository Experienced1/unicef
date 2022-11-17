package com.unicef.service.mypage;

import com.unicef.domain.Onetoone;
import com.unicef.dto.mypage.OnetooneReqDto;
import com.unicef.repository.mypage.OnetooneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OnetooneServiceImpl implements OnetooneService{

    private final OnetooneRepository onetooneRepository;

    @Override
    public boolean submit(OnetooneReqDto onetooneReqDto) throws Exception {
        int resultCount = 0;

        Onetoone onetoone = onetooneReqDto.toOnetooneEntity();
        resultCount = onetooneRepository.save(onetoone);

        if(resultCount == 0){
            throw new Exception("실패");
        }
        return true;
    }
}
