package com.unicef.dto.user;

import com.unicef.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRespDto {
    private int userId;
    private int roleId;

    private String mainUsername;
    private String oauthUsername;
    private String userProvider;

    private String userName; // 사용자 이름

    private String userPhone;

    private String userBirthdate;

    private String userEmail;
    private LocalDateTime createDate;

}
