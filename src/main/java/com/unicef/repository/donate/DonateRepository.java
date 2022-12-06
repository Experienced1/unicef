package com.unicef.repository.donate;

import com.unicef.domain.donate.Donate;
import com.unicef.domain.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DonateRepository {
    // table4 후원분야
    public int donateAreaInsert(Donate donateArea);
    // table5 후원
    public int donateInsert(Donate donate);
    public List<Donate> getDonateList(int user_id) throws Exception;

    public int deleteDonate(int id) throws Exception;
}
