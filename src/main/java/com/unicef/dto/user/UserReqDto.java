package com.unicef.dto.user;

import com.unicef.domain.user.User;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserReqDto {
    private int userId;
    private int roleId;

    @Pattern(regexp = "^[a-z]+[a-z0-9]{4,20}$",
            message = "아이디는 5자 이상 20자 이하여야 하며 숫자, 영문만 입력 가능합니다")
    private String mainUsername;
    private String oauthUsername;
    private String userProvider;

    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-!@#$%^&*_]{8,16}$",
            message="비밀번호는 8자 이상 16자 이하여야 하며 숫자, 영문, 특수기호를 포함해야 합니다")
    private String userPw;

    @Pattern(regexp = "^[가-힇]{2,6}$",
            message="이름은 2자 이상 6글자 이하여야 하며 한글만 입력 가능합니다")
    private String userName; // 사용자 이름

    @Pattern(regexp = "^[0-9]{10,11}$",
            message="휴대폰 번호는 10자 이상 11자 이하여야 하며 숫자만 입력 가능합니다")
    private String userPhone;

    @Pattern(regexp = "^[0-9]{8}$",
            message="생년월일은 8자여야 하며 숫자만 입력 가능합니다")
    private String userBirthdate;

    @Email(message = "잘못된 이메일 형식입니다")
    @NotBlank(message = "이메일은 비워 둘 수 없습니다")
    private String userEmail;

    public User toUserEntity(){ // table2 사용자분야
        return User.builder()
                .main_username(mainUsername)
                .oauth_username(oauthUsername)
                .user_provider(userProvider)
                .user_pw(new BCryptPasswordEncoder().encode(userPw))
                .user_name(userName)
                .user_phone(userPhone)
                .user_birthdate(userBirthdate)
                .user_email(userEmail)
                .build();
    }
}
