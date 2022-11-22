package com.unicef.repository.account;

import com.unicef.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRepository {
    public int save(User user);
    public int updateUserOauth2(User user);
    public User findUserByUserId(String userId);
}
