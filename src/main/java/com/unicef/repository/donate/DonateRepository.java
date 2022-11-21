package com.unicef.repository.donate;

import com.unicef.domain.Donate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonateRepository {
    // table4 후원분야
    public int donateAreaInsert(Donate donateArea);
    // table5 후원
    public int donateInsert(Donate donate);

}
