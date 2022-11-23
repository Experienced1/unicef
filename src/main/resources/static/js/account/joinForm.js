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

// 가입하기 버튼 누를 시 form첫번째 선택하기도
// 부탁드려요~

joinGoButton.onclick = () => {
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
      // validationError(error.responseJSON.data);
    },
  });
};

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
