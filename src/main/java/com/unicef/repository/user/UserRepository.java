package com.unicef.repository.user;

import com.unicef.domain.Faq;
import com.unicef.domain.user.User;
import com.unicef.dto.user.UserReqDto;
import com.unicef.dto.user.UserRespDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserRepository {
    // table2 사용자
    public int userInsert(User user);
    public User userSelect(String main_username);
    public List<User> getUserList() throws Exception;

    public int deleteUser(int id) throws Exception;
}
