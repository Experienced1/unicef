package com.unicef.service.auth;

import com.unicef.domain.account.User;
import com.unicef.repository.account.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
    // 로그인 아이디 중복체크
    private final UserRepository joinInfo;

    @Override
    public UserDetails loadUserByUsername(String main_username) throws UsernameNotFoundException {
        log.info("mainUsername 로그인 중복체크 >> {}", main_username); //form로그인 사용
        User user = joinInfo.userSelect(main_username);

        log.info("mainUsername 로그인 중복체크2 >> {}", user); //form로그인 사용

        if (user == null) {
            log.error("아이디를 찾지 못함");
            throw new UsernameNotFoundException("존재하지 않는 아이디입니다");
        }

        return new PrincipalDetails(user); 
        //UserDetails를 리턴해야하는데, 인페라서 파일을 새로 만들었다
    }
    
    
}
