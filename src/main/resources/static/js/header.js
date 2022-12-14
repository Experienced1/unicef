
const mainMenu = document.querySelector(".main-menu");
const headerMid = document.querySelector(".header-mid");
const headerMidsub = document.querySelector(".header-midsub");

const li = document.querySelectorAll("li");

// 후원하기 페이지 이동 //
$(function(){
    $('.support-button').click(function(){
        location.href = '/donate';
    });
});

// 스크롤 이동에 따른 헤더 변형 //
$(window).scroll(function(){
    $('.header-mid').css('left', 0-$(this).scrollLeft());
    $('.header-midsub').css('left', 0-$(this).scrollLeft());


    const scrollP = $(window).scrollTop();
    
    if(scrollP > 50){
        headerMid.style.top = "0px";
        headerMidsub.style.top = "100px";        
    }else{
        headerMid.style.top = "50px";
        headerMidsub.style.top = "150px";        
    }
});


// 서브메뉴 보이게 하기 //
mainMenu.onmouseover = () => {
    headerMidsub.classList.remove("invisible");
}

mainMenu.onmouseout = () => {
    headerMidsub.classList.add("invisible");
}

headerMidsub.onmouseover = () => {
    headerMidsub.classList.remove("invisible");
}

headerMidsub.onmouseout = () => {
    headerMidsub.classList.add("invisible");
}


// principal 로그인 로그아웃 관리 //
$(function(){
    const headerTopAuto = document.querySelector(".header-top-auto");
    let principal = getPrincipal();
    if(principal == "") {
        headerTopAuto.innerHTML = `
            <li><a href="/account/login">로그인</a></li>
            <li><a href="/account/join">회원가입</a></li>
            <li><button>기부금영수증</button></li>
            <li><a href="/community/faq">FAQ</a></li>
        `
    } else if(principal.user.role_id == "2") {
        headerTopAuto.innerHTML = `
            <li><a href="/logout">로그아웃</a></li>
            <li><a href="/admin/userlist">관리자페이지</a></li>
            <li><button>기부금영수증</button></li>
            <li><a href="/community/faq">FAQ</a></li>
        `;
    } else {
        headerTopAuto.innerHTML = `
            <li><a href="/logout">로그아웃</a></li>
            <li><a href="/mypage/myinfo">마이페이지</a></li>
            <li><button>기부금영수증</button></li>
            <li><a href="/community/faq">FAQ</a></li>
        `;
    }
});
