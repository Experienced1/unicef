package com.unicef.repository.donate;

import com.unicef.domain.DonateArea;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonateAreaRepository {
    public int donateAreaInsert(DonateArea donateArea);
}
