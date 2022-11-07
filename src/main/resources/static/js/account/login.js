const loginGoButton =  document.querySelector(".login-button");
const joinButton = document.querySelector(".join-button");

const loginInputs = document.querySelectorAll(".login-input");

//왜 안되는지 모르겟어요..ㅜㅜ
loginGoButton.onclick = () => {
    const loginform = document.querySelector("form");
}

joinButton.onclick = () => {
    location.href = "/account/join";
}
