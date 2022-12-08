package com.unicef.service.user;

import com.unicef.domain.user.User;
import com.unicef.dto.user.UserReqDto;
import com.unicef.dto.user.UserRespDto;
import com.unicef.exception.CustomValidationException;
import com.unicef.repository.user.UserRepository;
import com.unicef.service.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository joinInfo;

    // 아이디 중복체크
    @Override
    public boolean checkDuplicateMainUsername(String mainUsername) {
        User user = joinInfo.userSelect(mainUsername); // select 된다.
        log.info("[UserServiceImpl] mainUsername 회원가입 중복체크 >> {}", mainUsername);

        if (user != null) { // 아이디가 기존에 이미 있다면, (중복)
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("duplicateFlag", "이미 가입된 아이디입니다");
            throw new CustomValidationException("DuplicateMainUsername MainUsername", errorMap);
        }
        return true;
    }

    // table2 insert
    @Override
    public boolean user(UserReqDto userReqDto) throws Exception {
        User userEntity = userReqDto.toUserEntity();
        log.info("2번 테이블: {}", userEntity);
        int result2 = joinInfo.userInsert(userEntity);

        if(result2 == 0){ // 위에가 문제될 경우 resultCount가 0이되어 강제발생된다.
            log.info("에러2!!!!!!!!!!!!!!!!!!!! 페이지 만들어야함");
        }
        return false;
    }


    @Override // 사용자목록 가져오기
    public List<UserRespDto> getUserList() throws Exception {
        List<UserRespDto> list = new ArrayList<UserRespDto>();

        joinInfo.getUserList().forEach(user -> {
            list.add(user.getUserEntity());
        });

        return list;
    }

    @Override    // 아이디 찾기
    public User getSearchId(UserReqDto userReqDto) throws Exception {

        User toSearchEntity = userReqDto.toSearchEntity();
        log.info("[UserServiceImpl] toSearchEntity: {}", toSearchEntity);

        User userSearch = joinInfo.getSearchId(toSearchEntity);
        log.info("[UserServiceImpl] userSearch: {}", userSearch);

        return userSearch;
    }

    @Override    // 비밀번호 찾기
    public User getSearchPw(UserReqDto userReqDto) throws Exception {

        User toSearchEntity = userReqDto.toSearchEntity();
        log.info("[UserServiceImpl] toSearchEntity: {}", toSearchEntity);

        User userSearch = joinInfo.getSearchPw(toSearchEntity);
        log.info("[UserServiceImpl] userSearch: {}", userSearch);

        return userSearch;
    }
    @Override // 사용자 정보 변경 update
    public boolean updateUser(@AuthenticationPrincipal PrincipalDetails principalDetails, UserReqDto userReqDto) throws Exception {

        User user = principalDetails.getUser();
        User userEntity = userReqDto.toUserEntity();

//        log.info("[UserServiceImpl] user: {}", user);
//        log.info("[UserServiceImpl] userEntity: {}", userEntity);

        User userModRespDto = User.builder()
                .user_id(user.getUser_id())
                .role_id(user.getRole_id())
                .main_username(userEntity.getMain_username())
                .user_pw(userEntity.getUser_pw())
                .user_name(userEntity.getUser_name())
                .user_phone(userEntity.getUser_phone())
                .user_birthdate(userEntity.getUser_birthdate())
                .user_email(userEntity.getUser_email())
                .build();

        log.info("[UserServiceImpl] userModRespDto: {}", userModRespDto);

        int result3 = joinInfo.updateUser(userModRespDto);

        if(result3 == 0){ // 위에가 문제될 경우 resultCount가 0이되어 강제발생된다.
            log.info("[UserServiceImpl] 에러3! 페이지 만들어야함");
        }

        User userUpdate = joinInfo.userSelect(userModRespDto.getMain_username());
        principalDetails.setPrincipal(userUpdate);

        return false;
    }

    @Override // 사용자 비밀번호 변경 update
    public boolean updateUserPw(UserReqDto userReqDto) throws Exception {

        User editPwEntity = userReqDto.toEditPwEntity();
        int result3 = joinInfo.updateUserPw(editPwEntity);

        if(result3 == 0){ // 위에가 문제될 경우 resultCount가 0이되어 강제발생된다.
            log.info("[UserServiceImpl] 에러3! 페이지 만들어야함");
        }
        return false;
    }
    @Override
    public boolean deleteUser(int id) throws Exception {
        if(joinInfo.deleteUser(id) > 0){
            return true;
        }
        return false;
    }
}
