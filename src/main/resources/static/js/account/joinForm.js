const joinGoButton = document.querySelector(".join-button");
const joinInputs = document.querySelectorAll(".join-input");


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

// 가입하기 누를 경우 //

joinGoButton.onclick = () => {
        donateInfoData();
};

// ajax로 보내야 하는 데이터
function donateInfoData(){   
  let joinInfo = {
    mainUsername: joinInputs[0].value,
    userPw: joinInputs[1].value,
    // passwordCheck: joinInputs[2].value,
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
      alert("성공");
      // location.replace("/account/login");
    },
    error: (error) => {
      console.log(error);
      alert("실패~");
      validationError(error.responseJSON.data);
    },
  });
}

//<<<<<validationError>>>>>>

function validationError(error) {
    const accountErrors = $('.account-errors');
    const accountErrorList = $('.account-errors > ul');

    const errorMainUsername = error.mainUsername;
    const errorUserEmail = error.userEmail;
    const errorUserPw = error.userPw;
    const errorUserName = error.userName;

    alert(accountErrorList[0].innerHTML);
    alert(accountErrorList[1].innerHTML);
    // alert(accountErrorList[2].innerHTML);
    alert(accountErrorList[3].innerHTML);
    alert(accountErrorList[4].innerHTML);

    accountErrorList[0].innerHTML = `
        <li>${errorMainUsername}</li>
    `;
    accountErrorList[1].innerHTML = `
        <li>${errorUserPw}</li>
    `;
    accountErrorList[3].innerHTML = `
        <li>${errorUserName}</li>
    `;
    accountErrorList[4].innerHTML = `
        <li>${errorUserEmail}</li>
    `;

    accountErrors.removeClass('errors-invisible');
}
