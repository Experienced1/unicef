package com.unicef.repository;

import com.unicef.domain.Donate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonateRepository {
    public int donateSave(Donate donate);
}
