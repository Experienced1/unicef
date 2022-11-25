package com.unicef.repository.account;

import com.unicef.domain.account.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    // table2 사용자
    public int userInsert(User user);
    public User userSelect(String main_username);

}
