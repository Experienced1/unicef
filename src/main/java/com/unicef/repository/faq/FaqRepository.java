package com.unicef.repository.faq;

import com.unicef.domain.Faq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FaqRepository {
    public int save(Faq faq);
    public List<Faq> getFaqList(Map<String, Object> map) throws Exception;
}
