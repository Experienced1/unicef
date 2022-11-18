package com.unicef.domain;

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
    private int num_id;
    private int role_id;
    private String user_id;
    private String oauth_username;
    private String user_provider;
    private String user_pw;
    private String user_name;
    private int user_phone;
    private int user_birthdate;
    private String user_email;
    private LocalDateTime create_date;
    private LocalDateTime update_date;


}
