package com.unicef.repository;

import com.unicef.domain.Notice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeRepository {
    public String noticeSave(Notice notice);
}
