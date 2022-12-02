package com.unicef.controller.user.api;

import com.unicef.aop.annotation.ValidAspect;
import com.unicef.dto.user.UserReqDto;
import com.unicef.dto.donate.CMRespDto;
import com.unicef.service.user.UserService;
import com.unicef.service.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class UserApi {
    private final UserService userService;

    @PostMapping("/account/joinform/checkduplicate")
    public ResponseEntity<?> joinformcheckDuplicate(@RequestBody UserReqDto userReqDto) throws Exception {

        log.info("[UserApi] userInfoData 데이터: {}", userReqDto);
        userService.checkDuplicateMainUsername(userReqDto.getMainUsername());

        return ResponseEntity.ok(new CMRespDto<>(1, "아이디 중복체크 성공", userReqDto));
    }

    @ValidAspect
    @PostMapping("/account/joinform") //Json은 늘 @RequestBody가 따라와야한다
    public ResponseEntity<?> joinform(@Valid @RequestBody UserReqDto userReqDto,
                                       BindingResult bindingResult) throws Exception {

        log.info("[UserApi] userInfoData 데이터: {}", userReqDto);

        userService.checkDuplicateMainUsername(userReqDto.getMainUsername());
        userService.user(userReqDto);

        return ResponseEntity.ok(new CMRespDto<>(1, "table2.사용자 성공", userReqDto));
    }

    @GetMapping("/account/principal/member")
    public ResponseEntity<?> getPrincipalMember(@AuthenticationPrincipal PrincipalDetails principalDetails){

        log.info("[UserApi] js에 뿌려줄 principalDetail 데이터: {}", principalDetails);

        return ResponseEntity.ok().body(new CMRespDto<>(1, "로그인 사용자 정보", principalDetails == null ? "" : principalDetails));
    }


    @GetMapping("/admin/userlist")
    public ResponseEntity<?> getUserList() throws Exception {

        return ResponseEntity.ok(new com.unicef.dto.CMRespDto<>(1, "UserList 정보", userService.getUserList()));
    }

    @DeleteMapping("/admin/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) throws Exception{
        return ResponseEntity.ok(new com.unicef.dto.CMRespDto<>(1, "후원자 삭제", userService.deleteUser(id)));
    }

}
