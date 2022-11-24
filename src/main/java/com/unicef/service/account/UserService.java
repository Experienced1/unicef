package com.unicef.service.account;

import com.unicef.dto.account.UserReqDto;

public interface UserService {
    public boolean user(UserReqDto userReqDto) throws Exception;
}
