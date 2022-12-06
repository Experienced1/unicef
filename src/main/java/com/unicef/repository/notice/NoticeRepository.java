package com.unicef.repository.notice;

import com.unicef.domain.notice.AttachedFile;
import com.unicef.domain.notice.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeRepository {
    public int save(Notice notice);
    public int saveFiles(List<AttachedFile> attachedFileList);
    public List<Notice> getNoticeList(Map<String, Object> map) throws Exception;
    public Notice getNotice(int notice_id);
    public int setNotice(Notice notice) throws Exception;
    public int deleteNotice(int notice_id) throws Exception;
}
