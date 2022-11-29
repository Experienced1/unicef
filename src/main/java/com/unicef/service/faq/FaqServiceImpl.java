package com.unicef.service.faq;

import com.unicef.domain.Faq;
import com.unicef.dto.faq.FaqListRespDto;
import com.unicef.dto.faq.FaqModificationReqDto;
import com.unicef.dto.faq.FaqReqDto;
import com.unicef.repository.faq.FaqRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class FaqServiceImpl implements FaqService{

    private final FaqRepository faqRepository;

    @Override
    public boolean submit(FaqReqDto faqReqDto) throws Exception {
        int result;

        Faq faq = faqReqDto.toFaqEntity();

        result = faqRepository.save(faq);

        if(result == 0){
            log.info("에러발생");
        }

        return false;
    }

    @Override
    public List<FaqListRespDto> getFaqList() throws Exception {
        Map<String, Object> paramsMap = new HashMap<String, Object>();

        List<FaqListRespDto> list = new ArrayList<FaqListRespDto>();

        faqRepository.getFaqList(paramsMap).forEach(faq -> {
            list.add(faq.toListRespDto());
        });

        return list;
    }

    @Override
    public boolean updateFaq(FaqModificationReqDto faqModificationReqDto) throws Exception {

        boolean status = false;

        status = faqRepository.setFaq(faqModificationReqDto.toFaqEntity()) > 0;

        if(!status){
            log.info("error!!");
        }
        
        return status;
    }


}
