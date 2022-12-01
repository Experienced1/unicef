package com.unicef.repository.notice;

import com.unicef.domain.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeRepository {
    public int save(Notice notice);
    public List<Notice> getNoticeList(Map<String, Object> map) throws Exception;
    public int setNotice(Notice notice)throws Exception;
    public int deleteNotice(int notice_id) throws Exception;
}
