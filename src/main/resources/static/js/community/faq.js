// <<<<<<<<<<카테고리>>>>>>>>>>>>>>>>>>
const categorySelectInput = document.querySelector(".input-text .all-button");


// <<<<<<<<<<search>>>>>>>>>>>>>>>>>>
const searchInput = document.querySelector(".faq-search .faq-list-tab");
const searchButton = document.querySelector(".search-button");

let page = 1;
let category = "ALL";
let searchText = "";


// 페이지 읽기
window.onload = () => {
    getList();
   
}




//<<<<<<<<<카테고리>>>>>>>>>>>
categorySelectInput.onchange = () => {
    page = 1;
    category = categorySelectInput.value;
    getList();
}

