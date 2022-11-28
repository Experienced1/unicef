package com.unicef.service.auth;

import com.unicef.domain.account.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter //해당 user정보를 가져다쓰기위함
public class PrincipalDetails implements UserDetails {

    private User user; //db에서 가져온 객체
//    private Map<String, Object> attributes;


    public PrincipalDetails(User user) {
        this.user = user;
    }

//    public PrincipalDetails(User user, Map<String, Object> attributes) {
//        this.user = user;
//        this.attributes = attributes;
//    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { 
        // 계정이 가지고 있는 권한 목록 리턴

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(() -> user.getRole().getRole()); //람다식

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getUser_pw(); //시큐리티가 가져갈 비번
    }

    @Override
    public String getUsername() {
        return user.getMain_username(); //시큐리티가 가져갈 아이디
    }

    @Override
    public boolean isAccountNonExpired() {  // 계정의 만료 여부(계정의 사용기간 만료)
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {   // 계정의 잠김 여부(관리자가 강제로 사용을 금함)
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {  // 비밀번호 만료 여부(비밀번호 5회이상 틀렸을 때)
        return true;
    }

    @Override
    public boolean isEnabled() {    // 계정의 활성화 여부(휴먼 계정, 이메일 또는 전화번호 인증 필요)
        return true;
    }

//    @Override
//    public Map<String, Object> getAttributes() {
//        return attributes;
//    }

//    @Override
//    public String getName() {
//        return (String) attributes.get("name");
//    }
}