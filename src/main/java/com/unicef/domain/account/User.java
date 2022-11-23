package com.unicef.domain.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int user_id;
    private int role_id;
    private String main_username;
    private String oauth_username;
    private String user_provider;
    private String user_pw;
    private String user_name;
    private int user_phone;
    private int user_birthdate;
    private String user_email;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
