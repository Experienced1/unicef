package com.unicef.dto.account;

import com.unicef.domain.account.User;
import lombok.Data;

@Data
public class UserReqDto {
    private int userId;
    private int roleId;
    private String mainUsername;
    private String oauthUsername;
    private String userProvider;
    private String userPw;
    private String userName;
    private int userPhone;
    private int userBirthdate;
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
