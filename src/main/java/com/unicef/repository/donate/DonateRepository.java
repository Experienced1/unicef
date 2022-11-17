package com.unicef.repository.donate;

import com.unicef.domain.Donate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonateRepository {
    public int donateInsert(Donate donate);
}
