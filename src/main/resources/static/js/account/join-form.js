const joinGoButton = document.querySelector(".join-button");
const joinInputs = document.querySelectorAll(".join-input");

//enter누르면 회원가입 되기!
for(let i = 0; i < joinInputs.length; i++) {
    joinInputs[i].onkeyup = () => {
        if(window.event.keyCode == 13){
            if(i != 4) {
                joinInputs[i + 1].focus();
            }else {
                joinGoButton.click();
            }
        }
    }
}

// 가입하기버튼 누를 시
// 이렇게 하는거 맞나요...? 봐주세요...
joinGoButton.onclick = () => {

    let joinInfo = {
        id: joinInputs[0].value,
        password: joinInputs[1].value,
        passwordCheck: joinInputs[2].value,
        name: joinInputs[3].value,
        email: joinInputs[4].value
    }

    $.ajax({
        async: false,
        type: "post",
        url: "/api/account/join-form",
        contentType: "application/json",
        data: JSON.stringify(joinInfo),
        dataType: "json",
        success: (response) => {
            location.replace("/account/login");
        },
        error: (error) => {
            console.log(error);
            validationError(error.responseJSON.data);
        }
    });
}

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