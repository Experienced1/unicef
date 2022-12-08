package com.unicef.controller.user.api;

import com.unicef.aop.annotation.ValidAspect;
import com.unicef.domain.user.User;
import com.unicef.dto.donate.DonateReqDto;
import com.unicef.dto.user.UserReqDto;
import com.unicef.dto.donate.CMRespDto;
import com.unicef.dto.user.UserRespDto;
import com.unicef.service.user.UserService;
import com.unicef.service.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/account/principal/member") // 아이디 검증받습니다
    public ResponseEntity<?> getPrincipalMember(@AuthenticationPrincipal PrincipalDetails principalDetails){

        log.info("[UserApi] js에 뿌려줄 principalDetail 데이터: {}", principalDetails);

        return ResponseEntity.ok().body(new CMRespDto<>(1, "로그인 사용자 정보", principalDetails == null ? "" : principalDetails));
    }

    @PostMapping("/principal/password") // 비밀번호 검증
    public ResponseEntity<?> getPrincipalPassword(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestBody Map<String, Object> userPwMap) throws Exception {
        log.info("[UserApi] 비밀번호 검증중");

        boolean pwchk = new BCryptPasswordEncoder().matches((String)userPwMap.get("pwchk"), principalDetails.getUser().getUser_pw());
        log.info("[UserApi] 비밀번호 검증: {}", pwchk);

        if(pwchk) {
            return ResponseEntity.ok(new com.unicef.dto.CMRespDto<>(1, "비밀번호 확인", pwchk));
        }else{
            return ResponseEntity.badRequest().body(new com.unicef.dto.CMRespDto<>(1, "비밀번호 오류", pwchk));
        }
    }

    @PostMapping("/principal/searchdata/id") // 아이디 찾기
    public ResponseEntity<?> getSearchId(@RequestBody UserReqDto userReqDto) throws Exception {
        User userSearch = userService.getSearchId(userReqDto);

        if(userSearch.getMain_username() != null) {
            return ResponseEntity.ok(new com.unicef.dto.CMRespDto<>(1, "아이디 찾기 성공", userSearch));
        }else{
            return ResponseEntity.badRequest().body(new com.unicef.dto.CMRespDto<>(1, "아이디 찾기 실패", userSearch));
        }
    }

    @PostMapping("/principal/searchdata/pw") // 비밀번호 찾기
    public ResponseEntity<?> getSearchPw(@RequestBody UserReqDto userReqDto) throws Exception {
        User userSearch = userService.getSearchPw(userReqDto);

        if(userSearch.getUser_pw() != null) {
            return ResponseEntity.ok(new com.unicef.dto.CMRespDto<>(1, "계정 찾기 성공(비밀번호)", userSearch));
        }else{
            return ResponseEntity.badRequest().body(new com.unicef.dto.CMRespDto<>(1, "계정 찾기 실패(비밀번호)", userSearch));
        }
    }


    @GetMapping("/admin/userlist")
    public ResponseEntity<?> getUserList() throws Exception {
        List<UserRespDto> list = new ArrayList<UserRespDto>();
        list = userService.getUserList();

        return ResponseEntity.ok(new com.unicef.dto.CMRespDto<>(1, "UserList 정보", list));
    }

    @ValidAspect
    @PutMapping("/principal/updateuser") // 사용자 정보 변경
    public ResponseEntity<?> updateUser(@AuthenticationPrincipal PrincipalDetails principalDetails, @Valid @RequestBody UserReqDto userReqDto,
                                         BindingResult bindingResult) throws Exception {

        log.info("[UserApi] 회원정보 수정 데이터: {}", userReqDto);
        userService.updateUser(principalDetails, userReqDto);

        return ResponseEntity.ok(new com.unicef.dto.CMRespDto<>(1, "사용자 정보 수정", userReqDto));
    }

    @PutMapping("/principal/updateuserpw") // 비밀번호 정보 변경
    public ResponseEntity<?> updateUserPw(@RequestBody UserReqDto userReqDto) throws Exception {

        log.info("[UserApi] 회원정보 수정 데이터: {}", userReqDto);
        userService.updateUserPw(userReqDto);

        return ResponseEntity.ok(new com.unicef.dto.CMRespDto<>(1, "비밀번호 수정", userReqDto));
    }

    @DeleteMapping("/admin/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) throws Exception{
        return ResponseEntity.ok(new com.unicef.dto.CMRespDto<>(1, "후원자 삭제", userService.deleteUser(id)));
    }

}
