package com.unicef.service.account;

import com.unicef.dto.account.UserReqDto;
import com.unicef.dto.donate.DonateReqDto;

public interface UserService {
    public boolean user(UserReqDto userReqDto) throws Exception;
}
