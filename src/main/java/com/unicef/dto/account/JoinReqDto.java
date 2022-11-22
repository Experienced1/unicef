package com.unicef.dto.account;

import com.unicef.dto.validation.ValidationGroups;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Locale;

@Data
public class JoinReqDto {
    @NotBlank(message = "아이디는 필수 입력 값입니다.",
            groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 8, max = 16,
        message = "아이디는 8~16자 사이여야 합니다",
        groups = ValidationGroups.SizeCheckGroup.class)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d-_]*$",
            message = "아이디는 8~16자 영문 대 소문자, 숫자, 특수문자 (-)(_)를 사용할 수 있습니다.",
            groups = ValidationGroups.PatternCheckGroup.class)
    private String userId;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.",
            groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 8, max = 16,
        message = "비밀번호는 8~16자 사이여야 합니다",
        groups = ValidationGroups.SizeCheckGroup.class)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]*$",
            message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 포함해야합니다.",
            groups = ValidationGroups.PatternCheckGroup.class)
    private String userPw;

    @NotBlank(message = "비밀번호 확인은 필수 입력 값입니다.",
            groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 8, max = 16,
        message = "비밀번호는 8~16자 사이여야 합니다")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]*$",
            message = "위의 비밀번호와 같아야합니다.",
            groups = ValidationGroups.PatternCheckGroup.class)
    private String pwCheck;

    @NotBlank(message = "성명은 필수 입력 값입니다.",
            groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 1, max = 5,
        message = "성명은 한 글자 이상 다섯글자 이하로 입력 가능합니다.")
    @Pattern(regexp = "^[가-힇]*$",
            message = "성명은 한글만 입력가능하며 한 글자 이상 다섯글자 이하로 작성하세요",
            groups = ValidationGroups.PatternCheckGroup.class)
    private String userName;


    @Digits(integer = 6, fraction = 0,
        message = "생년월일은 6자리로 입력하세요",
        groups = ValidationGroups.SizeCheckGroup.class)
    @Positive(message = "생년월일은 필수 입력 값이며, 6자리로 숫자로만 입력가능합니다.",
            groups = ValidationGroups.NotBlankGroup.class)
    private int birthDate;


    @Digits(integer = 11, fraction=0,
        groups = ValidationGroups.SizeCheckGroup.class)
    @Positive(message = "휴대폰 번호는 필수 입력 값이며, 숫자로만 입력가능합니다.",
            groups = ValidationGroups.NotBlankGroup.class)
    private int userPhone;

    @Email
    @NotBlank(message = "이메일은 필수 입력 값입니다.",
            groups = ValidationGroups.NotBlankGroup.class)
    private String email;

}
