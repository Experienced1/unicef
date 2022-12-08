package com.unicef.service.user;

import com.unicef.domain.user.User;
import com.unicef.dto.user.UserReqDto;
import com.unicef.dto.user.UserRespDto;
import com.unicef.service.auth.PrincipalDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;

public interface UserService {
    public boolean checkDuplicateMainUsername(String mainUsername);
    public boolean user(UserReqDto userReqDto) throws Exception;

   public List<UserRespDto> getUserList() throws Exception;

    // 아이디 찾기
    public User getSearchId(UserReqDto userReqDto) throws Exception;

    // 비밀번호 찾기
    User getSearchPw(UserReqDto userReqDto) throws Exception;

    boolean updateUser(@AuthenticationPrincipal PrincipalDetails principalDetails, UserReqDto userReqDto) throws Exception;

    // 사용자 정보 변경 update
    boolean updateUserPw(UserReqDto userReqDto) throws Exception;

    boolean deleteUser(int id) throws Exception;
}
