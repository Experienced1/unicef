const loginTabs = document.querySelectorAll(".login-tab ul li");

loginTabs.forEach((tab, index) => {
    tab.onclick = () => {
        if(index == 0) {
            loginTabs[0].classList.add("on");
            loginTabs[1].classList.remove("on");
            document.querySelector(".logForm").classList.remove("logForm-invisible");
            document.querySelector(".logForm2").classList.add("logForm-invisible");
        }else{
            loginTabs[1].classList.add("on");
            loginTabs[0].classList.remove("on");
            document.querySelector(".logForm").classList.add("logForm-invisible");
            document.querySelector(".logForm2").classList.remove("logForm-invisible");
        }
    }
})

const usernameBtn = document.querySelector('.username-btn');
const userpwBtn = document.querySelector('.userpw-btn');

const searchIdInput = document.querySelectorAll(".search-id-input");
const searchPwInput = document.querySelectorAll(".search-pw-input");
const searchNewpwInput = document.querySelectorAll(".search-newpw-input");

const pwEdit = document.querySelector(".pw-edit");

//아이디 찾기 버튼   
usernameBtn.onclick = () => {    
    var searchIdName = searchIdInput[0].value; // 아이디찾기 - 이름
    var searchIdPhone = searchIdInput[1].value; // 아이디찾기 - 폰번호

    let searchIdInfo = {
        userName: searchIdName,
        userPhone: searchIdPhone
    };

    searchIdData(searchIdInfo);
};

//비밀번호 찾기 버튼   
userpwBtn.onclick = () => {
    var searchPwName = searchPwInput[0].value; // 비번찾기 - 이름
    var searchPwId = searchPwInput[1].value; // 비번찾기 - 아이디
    var searchPwPhone = searchPwInput[2].value; // 비번찾기 - 폰번호

    let searchIdInfo = {
        userName: searchPwName,
        mainUsername: searchPwId,
        userPhone: searchPwPhone
    };
    
    localStorage.setItem("searchIdInfo", JSON.stringify(searchIdInfo));    
    searchPwData(searchIdInfo);
};

//비밀번호 변경
function pwChange(){
    $('.pw-edit1').addClass('invisible').siblings().removeClass('invisible');

    //비밀번호 변경 버튼   
    $('.userpw-edit-btn').click(function(){
        var searchPwName = searchNewpwInput[0].value; // 새비밀번호
        if(passwdCheck.test(searchPwName)){  
            let searchInfo = JSON.parse(localStorage.getItem("searchIdInfo"));

            console.log(searchInfo);

            let searchPwInfo = {
                userName: searchInfo.userName,
                mainUsername: searchInfo.mainUsername,
                userPhone: searchInfo.userPhone,
                userPw: searchPwName
            };      

            searchEditPwData(searchPwInfo);

        }else if(searchPwName.length < 8 || searchPwName.length >= 16){
            alert("비밀번호는 8자 이상 16자 이하여야 합니다");
        }
        else{
            alert("비밀번호는 영문 대문자와 소문자, 숫자, 특수문자를 포함해야 합니다");
        }
    });
}


// 아이디 찾기
function searchIdData(searchInfo){  
    console.log("searchIdData: " + searchInfo);  
    
    $.ajax({
        async: false,
        type: "post",
        url: "/api/principal/searchdata/id",
        contentType: "application/json",
        data: JSON.stringify(searchInfo),
        dataType: "json",
        success: (response) => {
            console.log(response);
            alert("후원자님의 아이디는 " + response.data.main_username + " 입니다");
        },
        error: (error) => {
            console.log(error);
            alert("아이디 찾기 실패");
        },
    });
}

// 비밀번호 찾기
function searchPwData(searchInfo){  
    console.log("searchPwData: " + searchInfo);  
    
    $.ajax({
        async: false,
        type: "post",
        url: "/api/principal/searchdata/pw",
        contentType: "application/json",
        data: JSON.stringify(searchInfo),
        dataType: "json",
        success: (response) => {
            console.log(response);
            alert("비밀번호 검증 성공");
            pwChange();
        },
        error: (error) => {
            console.log(error);
            alert("비밀번호 검증 실패");
        },
    });
}

// 비밀번호 변경
function searchEditPwData(searchPwInfo){  
    console.log("searchPwData: " + searchPwInfo);  
    
    $.ajax({
        async: false,
        type: "put",
        url: "/api/principal/updateuserpw",
        contentType: "application/json",
        data: JSON.stringify(searchPwInfo),
        dataType: "json",
        success: (response) => {
            console.log(response);
            alert("비밀번호 변경 성공");
            localStorage.removeItem("searchIdInfo");
            location.replace("/account/login");
        },
        error: (error) => {
            console.log(error);
            alert("비밀번호 변경 실패");
        },
    });
}