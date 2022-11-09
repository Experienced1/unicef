
const mainMenu = document.querySelector(".main-menu");
const headerMid = document.querySelector(".header-mid");
const headerMidsub = document.querySelector(".header-midsub");

const li = document.querySelectorAll("li");

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

// 후원하기 페이지 이동 //
$(function(){
    $('.support-button').click(function(){
        location.href = '/templates/donate.html';
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

