package com.unicef.dto.account;

import com.unicef.domain.account.User;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserReqDto {
    private int userId;
    private int roleId;

    @Pattern(regexp = "^[a-z]+[a-z0-9]{7,16}$",
            message = "아이디는 8자 이상 16자 이하여야 하며 숫자, 영문만 입력 가능합니다")
    private String mainUsername;
    private String oauthUsername;
    private String userProvider;

    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-!@#$%^&*_]{8,16}$",
            message="비밀번호는 8자 이상 16자 이하여야 하며 숫자, 영문, 특수기호를 포함해야 합니다")
    private String userPw;

    @Pattern(regexp = "^[가-힇]{1,3}$",
            message="이름은 한글자에서 세글자여야 하며 한글만 입력 가능합니다")
    private String userName; // 사용자 이름
    private int userPhone;
    private int userBirthdate;

    @Email(message = "잘못된 이메일 형식입니다")
    @NotBlank(message = "이메일은 비워 둘 수 없습니다")
    private String userEmail;

    public User toUserEntity(){ // table2 사용자분야
        return User.builder()
                .main_username(mainUsername)
                .oauth_username(oauthUsername)
                .user_provider(userProvider)
                .user_pw(userPw)
                .user_name(userName)
                .user_phone(userPhone)
                .user_birthdate(userBirthdate)
                .user_email(userEmail)
                .build();
    }
}
