// <<<<<<<<<<카테고리>>>>>>>>>>>>>>>>>>
const categoryTabInput = document.querySelector(".category-tab .search-input");


// <<<<<<<<<<search>>>>>>>>>>>>>>>>>>
const searchInput = document.querySelector(".faq-search");
const searchButton = document.querySelector(".search-button");

let page = 1;
let category = "ALL";
let searchText = "";


// 페이지 읽기
window.onload = () => {
    getList();
   
}

function getList() {
    
    $.ajax({
        async: false,
        type: "get",

        //faq post 주소 붙여넣기!
        url: "",
        data: {
            // "키값" : 변수명
            "pageNumber" : page,
            "category" : category,
            "searchText" : searchText
        },
        dataType: "json",
        success: (response) => {
            console.log(response);
            if(response.data.length != 0){
                // 페이징 처리 할 때
                loadPageNumberButtons(response.data[0].faqTotalCount);
                // innerHTML에서 list추가
                addFaqList(response.data);
            }else{
                alert("검색 결과가 없습니다.");
            }
            
        },
        error: (error) => {
            console.log(error);
        }
    });
}




//<<<<<<<<<카테고리>>>>>>>>>>>
categorySelectInput.onchange = () => {
    page = 1;
    category = categorySelectInput.value;
    getList();
}

