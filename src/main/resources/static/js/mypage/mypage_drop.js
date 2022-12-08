// 현재 회원정보! //
let principal = getPrincipal();

var userId = principal.user.user_id;
var mainUsername = principal.user.main_username;
var userName = principal.user.user_name;
var userPhone = principal.user.user_phone;
var userEmail = principal.user.user_email;
var userBirthdate = principal.user.user_birthdate;

const deleteButton = document.querySelector('.delete-button');

//탈퇴하기 버튼   
deleteButton.onclick = () => {
    if(mainUsername != $('.idchk').val()){
        alert("아이디 검증 실패")
    }else{
        pwchk($('.pwchk').val())
    }
};

// 아이디 비밀번호 검증
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
            userDeleteRequest(userId);
        },
        error: (error) => {
            console.log(error);
            alert("비밀번호 검증 실패");
        },
    });
}

// 탈퇴하기 요청
function userDeleteRequest(userId) {
    $.ajax({
        async: false,
        type: "delete",
        url: "/api/admin/user/" + userId,
        dataType: "json",
        success: (response) => {
            alert("회원 삭제 완료!");
            location.replace("/logout");
        },
        error: (error) => {
            alert("회원 삭제 실패!");
            console.log(error);
        }
    });
}