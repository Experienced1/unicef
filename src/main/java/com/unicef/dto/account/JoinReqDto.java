package com.unicef.dto.account;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class JoinReqDto {
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[-_])[a-zA-Z\\d-_]{8,16}$",
            message = "아이디는 8~16자 영문 대 소문자, 숫자, 특수문자 (-)(_)를 사용할 수 있습니다.")
    private String userId;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]{8,16}$",
            message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 포함해야합니다.")
    private String userPw;

    @NotBlank(message = "비밀번호 확인은 필수 입력 값입니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]{8,16}$",
            message = "위의 비밀번호와 같아야합니다.")
    private String pwCheck;

    @NotBlank(message = "성명은 필수 입력 값입니다.")
    @Pattern(regexp = "^[가-힇]{1,5}$",
            message = "성명은 한글만 입력가능하며 한 글자 이상 다섯글자 이하로 작성하세요")
    private String userName;


    @Digits(integer = 6, fraction = 0, message = "생년월일은 6자리로 입력가능합니다.")
    @PositiveOrZero(message = "숫자로만 입력 가능합니다.")
    private int birthDate;


    @Digits(integer = 11, fraction=0, message = "잘못된 입력입니다.")
    @PositiveOrZero(message = "숫자로만 휴대폰 번호를 입력해주세요")
    private int userPhone;

    @Email
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
//    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
    private String email;

}
