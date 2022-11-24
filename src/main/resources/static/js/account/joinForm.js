const joinGoButton = document.querySelector(".join-button");
const joinInputs = document.querySelectorAll(".join-input");
const checkButton = document.querySelector(".check-button");


//enter누르면 회원가입 되기!
for (let i = 0; i < joinInputs.length; i++) {
  joinInputs[i].onkeyup = () => {
    if (window.event.keyCode == 13) {
      if (i != 4) {
        joinInputs[i + 1].focus();
      } else {
        joinGoButton.click();
      }
    }
  };
}

// 아이디 중복 확인 누를 경우 //
checkButton.onclick = () => {
  donateInfoData();
};

// 가입하기 누를 경우 //
joinGoButton.onclick = () => {
  donateInfoData();
};

// ajax로 보내야 하는 데이터
function donateInfoData(){   
  let joinInfo = {
    mainUsername: joinInputs[0].value,
    userPw: joinInputs[1].value,
    userName: joinInputs[3].value,
    userEmail: joinInputs[4].value,
  };

  console.log(joinInfo);

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
      validationError(error.responseJSON.data);
    },
  });
}

//<<<<<validationError>>>>>>

function validationError(error) {
    const accountErrors = $('.account-errors');
    const accountErrorList = $('.account-errors > ul');

    const errorMainUsername = error.mainUsername;
    const errorUserPw = error.userPw;
    const errorUserName = error.userName;
    const errorUserEmail = error.userEmail;

    const errorDuplicateFlag = error.duplicateFlag;
    
    for(i = 0; i < accountErrorList.length; i++){
      accountErrorList[i].innerHTML = "";
    }

    //아이디
    if(errorMainUsername != undefined){
      accountErrorList[0].innerHTML = `
          <li>${errorMainUsername}</li>
      `
    };
    
    if(errorDuplicateFlag != undefined){
      accountErrorList[0].innerHTML = `
          <li>${errorDuplicateFlag}</li>
      `
    }

    //비밀번호
    if(errorUserPw != undefined){
      accountErrorList[1].innerHTML = `
          <li>${errorUserPw}</li>
      `
    };

    //비밀번호 확인
    if($('#user-pw-check').val() != $('#user-pw').val()){
      accountErrorList[2].innerHTML = `
          <li>비밀번호가 일치하지 않습니다</li>
      `
    };

    //성명
    if(errorUserName != undefined){
      accountErrorList[3].innerHTML = `
          <li>${errorUserName}</li>
      `
    };

    //이메일
    if(errorUserEmail != undefined){
      accountErrorList[4].innerHTML = `
          <li>${errorUserEmail}</li>
      `
    };

    accountErrors.removeClass('errors-invisible');
}
