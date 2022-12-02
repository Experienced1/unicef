const loginGoButton = document.querySelector(".login-button");
const joinButton = document.querySelector(".join-button");

const loginInputs = document.querySelectorAll(".login-input");

// enter누르면 로그인하기!
for (let i = 0; i < loginInputs.length; i++) {
  loginInputs[i].onkeyup = () => {
    if (window.event.keyCode == 13) {
      if (i != 1) {
        loginInputs[i + 1].focus();
      }
    }
  };
}

// 로그인 버튼 누를 시 form첫번째 선택하기
// 부탁드려요~~

joinButton.onclick = () => {
  location.href = "/account/join";
};
