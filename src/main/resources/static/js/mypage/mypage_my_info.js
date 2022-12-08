// 현재 회원정보! //
let principal = getPrincipal();

var userId = principal.user.user_id;
var mainUsername = principal.user.main_username;
var userName = principal.user.user_name;
var userPhone = principal.user.user_phone;
var userEmail = principal.user.user_email;
var userBirthdate = principal.user.user_birthdate;

const articleContent = document.querySelector('.article2');
articleContent.innerHTML = `
    <div>                                    
        <label>아이디</label>
        <input class="update-input" type="text" value="${mainUsername}" readonly>
        <div class="account-errors">
            <ul>
                <li>아이디는 변경이 불가능합니다.</li>
            </ul>
        </div>
    </div>
    <div class="password-edit">                                    
        <label>새 비밀번호</label>
        <input class="update-input" type="password" placeholder="8-16자의 영문 및 숫자, 특수문자를 모두 포함">
        <div class="account-errors errors-invisible">
            <ul>
            </ul>
        </div>
    </div>
    <div>
        <label>성명</label>
        <input class="update-input" type="text" value="${userName}" required>
        <div class="account-errors errors-invisible">
            <ul>
            </ul>
        </div>
    </div>
    <div>                                    
        <label>휴대폰번호</label>
        <input class="update-input" type="text" value="${userPhone}">
        <div class="account-errors errors-invisible">
            <ul>
            </ul>
        </div>
    </div>
    <div>                                    
        <label>생년월일</label>
        <input class="update-input" type="text" value="${userBirthdate}">
        <div class="account-errors errors-invisible">
            <ul>
            </ul>
        </div>
    </div>
    <div>                                    
        <label>이메일</label>
        <input class="update-input" type="text" value="${userEmail}">
        <div class="account-errors errors-invisible">
            <ul>
            </ul>
        </div>
    </div>
    <button class="drop-btn"><a href="/mypage/drop">웹사이트회원탈퇴</a></button>
    <button class="edit-done-btn sky-button button">수정하기</button>     
`    

const editDoneBtn = document.querySelector(".edit-done-btn");
const updateInputs = document.querySelectorAll(".update-input");
const checkButton = document.querySelector(".check-button");

const pwchkInput = document.querySelector('.pwchk');
const editGoBtn = document.querySelector('.edit-go-btn');

const accountErrors = $('.account-errors');
const accountErrorList = $('.account-errors > ul');

// enter누르면 비밀번호 검증!
pwchkInput.onkeyup = () => {
    if (window.event.keyCode == 13) {
        pwchkValue = $('.pwchk').val();
        pwchk(pwchkValue);
    }
};

//확인버튼 클릭했을때 비밀번호 검증!
editGoBtn.onclick = () => {
    pwchkValue = $('.pwchk').val();
    pwchk(pwchkValue);
};

//변경 비밀번호
updateInputs[1].onkeyup = () => {
    const userPwUD = updateInputs[1].value;
  
    if(passwdCheck.test(userPwUD)){
      accountErrorList[1].innerHTML = "";
    }else if(userPwUD.length < 8 || userPwUD.length >= 16){
      accountErrorList[1].innerHTML = `
      <li>비밀번호는 8자 이상 16자 이하여야 합니다</li>
    `
    }
    else{
      accountErrorList[1].innerHTML = `
      <li>비밀번호는 영문 대문자와 소문자, 숫자, 특수문자를 포함해야 합니다</li>
    `
    }
    accountErrors.removeClass('errors-invisible');    
}

//성명
updateInputs[2].onkeyup = () => {
    const userNameUD = updateInputs[2].value;

    if(nameCheck.test(userNameUD)){
      accountErrorList[2].innerHTML = "";
    }else if(userNameUD.length <= 2 || userNameUD.length >= 6){
      accountErrorList[2].innerHTML = `
      <li>이름은 2자 이상 6자 이하여야 합니다</li>
    `
    }
    else{
      accountErrorList[2].innerHTML = `
      <li>이름은 한글만 입력 가능합니다</li>
    `
    }
    accountErrors.removeClass('errors-invisible');
};
  
//휴대폰 번호
updateInputs[3].onkeyup = () => {
    const userPhoneUD = updateInputs[3].value;
  
    if(phonNumberCheck.test(userPhoneUD)){
      accountErrorList[3].innerHTML = "";
    }
    else{
      accountErrorList[3].innerHTML = `
      <li>잘못된 휴대폰 형식입니다</li>
    `
    }
    accountErrors.removeClass('errors-invisible');
};
  
//생년월일
updateInputs[4].onkeyup = () => {
    const userBirthdateUD = updateInputs[4].value;
  
    if(birthdayCheck.test(userBirthdateUD)){
      accountErrorList[4].innerHTML = "";
    }
    else{
      accountErrorList[4].innerHTML = `
      <li>잘못된 생년월일 형식입니다</li>
    `
    }
    accountErrors.removeClass('errors-invisible');
};

//이메일
updateInputs[5].onkeyup = () => {
    const userEmailUD = updateInputs[5].value;
  
    if(emailCheck.test(userEmailUD)){
      accountErrorList[5].innerHTML = "";
    }
    else{
      accountErrorList[5].innerHTML = `
      <li>잘못된 이메일 형식입니다</li>
    `
    }
    accountErrors.removeClass('errors-invisible');
};
 
//수정완료버튼!
editDoneBtn.onclick = () => {
    updateUser();
};

  
// 비밀번호 검증
function pwchk(pwchkValue){  
    console.log("pwchkValue: " + pwchkValue);
  
    let pwchkInfo = {
        pwchk: pwchkValue
    };

    $.ajax({
        async: false,
        type: "post",
        url: "/api/principal/password",
        contentType: "application/json",
        data: JSON.stringify(pwchkInfo),
        dataType: "json",
        success: (response) => {
        console.log(response);
            alert("비밀번호 검증 완료");
            $('.my-info').addClass('invisible'); // my-info 열린페이지를 숨긴다
            $('.my-info-edit').removeClass('invisible'); // my-info-edit 숨기페이지를 보이게한다
        },
        error: (error) => {
            console.log(error);
            alert("비밀번호 검증 실패");
        },
    });
}


// 수정하기로 보내야 하는 데이터
function updateUser(){   
    let updateUserInfo = {
        mainUsername: updateInputs[0].value, // 아이디
        userPw: updateInputs[1].value, // 비밀번호
        userName: updateInputs[2].value, //성명
        userPhone: updateInputs[3].value, //휴대폰번호
        userBirthdate: updateInputs[4].value, //생년월일
        userEmail: updateInputs[5].value //이메일
    };

    console.log("updateUserInfo: " + updateUserInfo);
  
    $.ajax({
        async: false,
        type: "put",
        url: "/api/principal/updateuser",
        contentType: "application/json",
        data: JSON.stringify(updateUserInfo),
        dataType: "json",
        success: (response) => {
            console.log(response);
            //수정 완료 팝업 이벤트
            $('.edit-popup').removeClass('invisible');
            $('.edit-done').click(function(){
                $('.edit-popup').addClass('invisible');
            });
            location.replace("/main");
        },
        error: (error) => {
            console.log(error);
            var msg = ">> 회원수정 실패";
            msg += JSON.stringify(error.responseJSON.data.mainUsername)
            msg += JSON.stringify(error.responseJSON.data.userPw)
            msg += JSON.stringify(error.responseJSON.data.userName)
            msg += JSON.stringify(error.responseJSON.data.userPhone)
            msg += JSON.stringify(error.responseJSON.data.userBirthdate) 
            msg += JSON.stringify(error.responseJSON.data.userEmail)
            msg = msg.replaceAll("undefined", "")
            msg = msg.replace(/\"/gi, "\n")
            msg = msg.replaceAll("\n\n", "\n")
            alert(msg);
        },
    });
}
