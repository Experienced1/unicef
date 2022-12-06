package com.unicef.service.user;

import com.unicef.dto.user.UserReqDto;
import com.unicef.dto.user.UserRespDto;

import java.util.List;

public interface UserService {
    public boolean checkDuplicateMainUsername(String mainUsername);
    public boolean user(UserReqDto userReqDto) throws Exception;

   public List<UserRespDto> getUserList() throws Exception;

    boolean deleteUser(int id) throws Exception;
}
