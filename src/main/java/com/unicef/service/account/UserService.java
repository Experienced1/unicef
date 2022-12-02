package com.unicef.service.account;

import com.unicef.dto.account.UserReqDto;

public interface UserService {
    public boolean checkDuplicateMainUsername(String mainUsername);
    public boolean user(UserReqDto userReqDto) throws Exception;

}
