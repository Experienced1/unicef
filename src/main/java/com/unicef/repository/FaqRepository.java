package com.unicef.repository;

import com.unicef.domain.Faq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FaqRepository {
    public int save(Faq faq);
}
