package com.unicef.repository.mypage;

import com.unicef.domain.Onetoone;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OnetooneRepository {
    public int save(Onetoone onetoone);
}
