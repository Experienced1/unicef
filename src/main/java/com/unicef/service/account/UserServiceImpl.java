package com.unicef.service.account;

import com.unicef.domain.account.User;
import com.unicef.dto.account.UserReqDto;
import com.unicef.repository.account.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository joinInfo;

    @Override
    public boolean user(UserReqDto userReqDto) throws Exception {
        // table2
        User userEntity = userReqDto.toUserEntity();
        log.info("2번 테이블: {}", userEntity);
        int result2 = joinInfo.userInsert(userEntity);

        if(result2 == 0){ // 위에가 문제될 경우 resultCount가 0이되어 강제발생된다.
            log.info("에러2!!!!!!!!!!!!!!!!!!!! 페이지 만들어야함");
//            throw new CustomInternalServerErrorException("상품 등록 실패"); //e.getMessage가 상품등록실패뜸
        }
        return false;
    }
}
