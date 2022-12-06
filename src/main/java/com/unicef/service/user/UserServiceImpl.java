package com.unicef.service.user;

import com.unicef.domain.user.User;
import com.unicef.dto.donate.DonateRespDto;
import com.unicef.dto.faq.FaqListRespDto;
import com.unicef.dto.user.UserReqDto;
import com.unicef.dto.user.UserRespDto;
import com.unicef.exception.CustomValidationException;
import com.unicef.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
            log.info("[UserServiceImpl] 에러2! 페이지 만들어야함");
        }
        return false;
    }


    @Override
    public List<UserRespDto> getUserList() throws Exception {
        List<UserRespDto> list = new ArrayList<UserRespDto>();

        joinInfo.getUserList().forEach(user -> {
            list.add(user.getUserEntity());
        });

        return list;
    }

    @Override
    public boolean deleteUser(int id) throws Exception {
        if(joinInfo.deleteUser(id) > 0){
            return true;
        }
        return false;
    }
}
