package com.unicef.config;

import com.unicef.handler.AuthFailureHandler;
import com.unicef.service.auth.PrincipalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity // 기존의 WebSecurityConfigurerAdapter 클래스를 해당 SecurityConfig로 대체하겠다.
// 시큐리티에 등록하는거. extends랑 별개
@Configuration //스프링의 설정 클래스. 이래야 IoC에 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private final PrincipalOauth2Service principalOauth2Service;

    @Bean // @Configuration와 세트로 사용. IoC빈등록방법
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // 암호화 비번
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 이게 기존세팅: super.configure(http);
        // security password: 71fa6981-7015-4029-a171-e6cbfc40aef4 이걸 만들어준다
        //logout도 자동으로 만들어짐. 관련 페이지 전부 막힘... (localhost:8000 전부 막힘)
        
        //아래는 override 세팅법
        http.csrf().disable();
        http.httpBasic().disable(); // httpBasic에서 제공해주는 로그인 사용X 선언. 비활성화.
        http.authorizeRequests() // 모든 요청시에 실행을 해라

                /*<<<<<<<<< Page >>>>>>>>>*/
                .antMatchers("/admin/**", "/api/admin/**")
                .hasRole(("ADMIN")) // 관리자만 접근가능

                .antMatchers("/donate/**", "/mypage/**")
                .access("hasRole('USER') or hasRole('ADMIN')") // 회원과 관리자만 접근가능

                .antMatchers("/", "/main", "/account/**" , "/involve/**", "/community/**", "/unicef/**")
                .permitAll() // 전원 접근 가능

                /*<<<<<<<<< Resource >>>>>>>>>*/
                .antMatchers("/static/**", "/image/**")
                .permitAll() // 모두 접근 권한 허용해라

                /*<<<<<<<<< API >>>>>>>>>*/
                .antMatchers("/api/account/**", "/api/donate")
                .permitAll()

                .anyRequest() // antMatchers외의 다른 모든 요청들은
//                .permitAll() // 수업을 위해 잠시 허용시켜둠
                .denyAll() // 모두 접근 권한 차단해라

                .and() // 그리고!!!
                .formLogin() // [메인객체] 폼 로그인 방식으로 인증해라
                    .usernameParameter("main_username") //username일 경우 생략가능 (기본값이 username)
                    .passwordParameter("user_pw")
                    //PrincipalDetailService 에서 loadUserByUsername의 (파라미터)와 값이 동일해야함!
                    .loginPage("/account/login") // 우리가 만든 로그인 페이지를 사용해라 (GET 요청)
                    .loginProcessingUrl("/account/login")
                    // 로그인 로직(PrincipalDetailsService)의 loadUserByUsername 메소드 호출 (post 요청)
                    // security 라이브러리에서 컨트롤러가 이미 만들어져있다. 거기에 포스트매핑한다.
                    // html form 에서 /account/login 로 요청을 날림!
                    .failureHandler(new AuthFailureHandler()) // 로그인실패시
                    .defaultSuccessUrl("/main")
                .and()
                    .logout()
                    .logoutSuccessUrl("/main");

//                .and()
//                    .oauth2Login()
//                    .userInfoEndpoint()
//                    /*
//                    * 1. google, naver, kakao 로그인 요청
//                    * -> 코드를 발급
//                    * 2. 발급받은 코드로 에세스 토큰을 발급요청
//                    * -> 에세스토큰 발급
//                    * 3. 발급받은 에세스토큰으로 스코프에 등록된 프로필 정보를 요청할 수 있게 된다.
//                    * 4. 해당 정보를 response 또는 Attributes로 전달받음
//                    * */
//                    .userService(principalOauth2Service)
//                .and()
//                    .defaultSuccessUrl("/index"); // "이전 페이지가 없는 경우"에만 로그인 성공시 index로 보낸다.
//                    //보통 자동으로 이전 페이지를 기억했다가 로그인 페이지 전 페이지로 돌아간다.
    }
}
