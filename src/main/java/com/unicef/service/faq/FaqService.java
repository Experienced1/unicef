package com.unicef.service.faq;

import com.unicef.dto.faq.FaqListRespDto;
import com.unicef.dto.faq.FaqModificationReqDto;
import com.unicef.dto.faq.FaqReqDto;

import java.util.List;

public interface FaqService {
    public boolean submit(FaqReqDto faqReqDto) throws Exception;

    public List<FaqListRespDto> getFaqList() throws Exception;

    public boolean updateFaq(FaqModificationReqDto faqModificationReqDto) throws Exception;

    public boolean deleteFaq(int id) throws Exception;
}
