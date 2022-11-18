package com.unicef.dto.notice;

import com.unicef.domain.NoticeImgFile;
import com.unicef.dto.validation.ValidationGroups;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;

import java.util.List;

@Builder
@Data

public class NoticeReqDto {


    @NotBlank(message = "제목은 빈 값일 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    private String noticeTitle;

    @NotBlank(message = "내용은 빈 값일 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Length(max = 10000)
    private String noticeContent;

    private List<NoticeImgFile> NoticeImgFile;



}
