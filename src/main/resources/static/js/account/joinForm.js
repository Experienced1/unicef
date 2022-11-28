const joinGoButton = document.querySelector(".join-button");
const joinInputs = document.querySelectorAll(".join-input");
const checkButton = document.querySelector(".check-button");

const accountErrors = $('.account-errors');
const accountErrorList = $('.account-errors > ul');


// 유효성 체크! //
var userIdCheck = RegExp(/^[A-Za-z0-9_\-]{5,20}$/);
var passwdCheck = RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^*()\-_=+\\\|\[\]{};:\'",.<>\/?]).{8,16}$/);
var nameCheck = RegExp(/^[가-힣]{2,6}$/);
var nickNameCheck = RegExp(/^[가-힣a-zA-Z0-9]{2,10}$/);
var emailCheck = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
var birthdayCheck = RegExp(/^(19|20)[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/);
var phonNumberCheck = RegExp(/^01[0179][0-9]{7,8}$/);

// 아이디
joinInputs[0].onkeyup = () => {
  const mainUsername = joinInputs[0].value;

  if(userIdCheck.test(mainUsername)){
    accountErrorList[0].innerHTML = "";
  }else if(mainUsername.length <= 5 || mainUsername.length >= 20){
    accountErrorList[0].innerHTML = `
    <li>아이디는 5자 이상 20자 이하여야 합니다</li>
  `
  }
  else{
    accountErrorList[0].innerHTML = `
    <li>아이디는 영문, 숫자만 입력 가능합니다</li>
  `
  }
  accountErrors.removeClass('errors-invisible');
};

//비밀번호
joinInputs[1].onkeyup = () => {
  const userPw = joinInputs[1].value;

  if(passwdCheck.test(userPw)){
    accountErrorList[1].innerHTML = "";
  }else if(userPw.length < 8 || userPw.length >= 16){
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
};

//비밀번호 확인
joinInputs[2].onkeyup = () => {
  if($('#user-pw-check').val() != $('#user-pw').val()){
    accountErrorList[2].innerHTML = `
        <li>비밀번호가 일치하지 않습니다</li>
    `
    accountErrors.removeClass('errors-invisible');
  }else{
    accountErrorList[2].innerHTML = "";
    accountErrors.addClass('errors-invisible');
  };
}

//성명
joinInputs[3].onkeyup = () => {
  const userName = joinInputs[3].value;

  if(nameCheck.test(userName)){
    accountErrorList[3].innerHTML = "";
  }else if(userName.length <= 2 || userName.length >= 6){
    accountErrorList[3].innerHTML = `
    <li>이름은 2자 이상 6자 이하여야 합니다</li>
  `
  }
  else{
    accountErrorList[3].innerHTML = `
    <li>이름은 한글만 입력 가능합니다</li>
  `
  }
  accountErrors.removeClass('errors-invisible');
};

//이메일
joinInputs[4].onkeyup = () => {
  const userEmail = joinInputs[4].value;

  if(emailCheck.test(userEmail)){
    accountErrorList[4].innerHTML = "";
  }
  else{
    accountErrorList[4].innerHTML = `
    <li>잘못된 이메일 형식입니다</li>
  `
  }
  accountErrors.removeClass('errors-invisible');
};


// 아이디 중복 확인 누를 경우 //
checkButton.onclick = () => {
  if(accountErrorList[0].innerHTML == ""){
    checkDuplicate();
  }else{
    alert("잘못된 아이디 형식입니다");
  }
};

// 중복확인으로 보내야 하는 데이터
function checkDuplicate(){   
  let joinInfo = {
    mainUsername: joinInputs[0].value,
    userPw: joinInputs[1].value,
    userName: joinInputs[3].value,
    userEmail: joinInputs[4].value,
  };

  console.log("joinInfo: " + joinInfo);

  $.ajax({
    async: false,
    type: "post",
    url: "/api/account/joinform/checkduplicate",
    contentType: "application/json",
    data: JSON.stringify(joinInfo),
    dataType: "json",
    success: (response) => {
      console.log(response);
      alert("사용가능한 아이디입니다");
    },
    error: (error) => {
      console.log(error);
      alert("이미 가입된 아이디입니다");
    },
  });
}

// 가입하기 누를 경우 //
joinGoButton.onclick = () => {
  donateInfoData();
};

// 가입하기로 보내야 하는 데이터
function donateInfoData(){   
  let joinInfo = {
    mainUsername: joinInputs[0].value,
    userPw: joinInputs[1].value,
    userName: joinInputs[3].value,
    userEmail: joinInputs[4].value,
  };

  console.log("joinInfo: " + joinInfo);

  $.ajax({
    async: false,
    type: "post",
    url: "/api/account/joinform",
    contentType: "application/json",
    data: JSON.stringify(joinInfo),
    dataType: "json",
    success: (response) => {
      console.log(response);
      alert("회원가입 완료");
      location.replace("/account/login");
    },
    error: (error) => {
      console.log(error);
      alert("회원가입 실패");
    },
  });
}