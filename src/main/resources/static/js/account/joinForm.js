const joinGoButton = document.querySelector(".join-button");

joinGoButton.onclick = () => {};

//enter누르면 회원가입 되기!
// for (let i = 0; i < joinInputs.length; i++) {
//   joinInputs[i].onkeyup = () => {
//     if (window.event.keyCode == 13) {
//       if (i != 4) {
//         joinInputs[i + 1].focus();
//       } else {
//         joinGoButton.click();
//       }
//     }
//   };
// }

// 가입하기 버튼 누를 시 form첫번째 선택하기도
// 부탁드려요~

joinGoButton.onclick = () => {
  const joinInputs = document.querySelectorAll(".join-input");

  let joinInfo = {
    userId: joinInputs[0].value,
    userPw: joinInputs[1].value,
    pwCheck: joinInputs[2].value,
    userName: joinInputs[3].value,
    birthDate: joinInputs[4].value,
    userPhone: joinInputs[5].value,
    email: joinInputs[6].value,
  };

  $.ajax({
    async: false,
    type: "post",
    url: "/api/account/join/form",
    contentType: "application/json",
    data: JSON.stringify(joinInfo),
    dataType: "json",
    success: (response) => {
      // location.replace("/account/login");
    },
    error: (error) => {
      // console.log(error);
      // validationError(error.responseJSON.data);
    },
  });
};

// // 비밀번호 일치 확인
//   $('.join-input').focusout(function () {
//     var pwd1 = $("#user-pw").val();
//     var pwd2 = $("#user-pw-check").val();

//     if(pwd1 != " && pwd2 ==") {
//       null;
//     } else if (pwd1 != "" || pwd2 != "") {
//       if(pwd1 == pwd2) {
//         $("#alert-success").css('display', 'inline-block');
//         $("#alert-danger").css('display', 'none');
//       } else {
//         alert("비밀번호가 일치하지 않습니다. 비밀번호를 재확인해주세요.");
//         $("#alert-success").css('display', 'none');
//         $("#alert-danger").css('display', 'inline-block');
//       }
//     }
//   });

//<<<<<validationError>>>>>>

// function validationError(error) {
//     const accountErrors = document.querySelectorAll(".account-errors");
//     const accountErrorList = accountErrors.querySelectorAll("ul");

//     const errorValues = Object.values(error);

//     accountErrorList.innerHTML = "";

//     errorValues.forEach((value) => {
//         accountErrorList.innerHTML += `
//             <li>${value}</li>
//         `;
//     });

//     accountErrors.classList.remove("errors-invisible");
// }
