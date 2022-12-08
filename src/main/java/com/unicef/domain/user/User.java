package com.unicef.domain.user;

import com.unicef.dto.user.UserRespDto;
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
    private Role role;
    private String main_username;
    private String oauth_username;
    private String user_provider;
    private String user_pw;
    private String user_name;
    private String user_phone;
    private String user_birthdate;
    private String user_email;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

    private int donate_amount;
    private int donate_id;
    private int total_amount;
    private int count_donate;

    public UserRespDto getUserEntity(){
        return UserRespDto.builder()
                .userId(user_id)
                .mainUsername(main_username)
                .userName(user_name)
                .userPhone(user_phone)
                .userBirthdate(user_birthdate)
                .userEmail(user_email)
                .createDate(create_date)
                .donateAmount(donate_amount)
                .donateId(donate_id)
                .totalAmount(total_amount)
                .countDonate(count_donate)
                .build();
    }
}
