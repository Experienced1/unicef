// // <<<<<<<<<<카테고리>>>>>>>>>>>>>>>>>>
// const categoryTabInput = document.querySelector(".category-tab .search-input");


// // <<<<<<<<<<search>>>>>>>>>>>>>>>>>>
// const searchInput = document.querySelector(".faq-search");
// const searchButton = document.querySelector(".search-button");

// let page = 1;
// let category = "ALL";
// let searchText = "";


// // 페이지 읽기
// window.onload = () => {
//     getList();
   
// }

// function getList() {
    
//     $.ajax({
//         async: false,
//         type: "get",

//         //faq post 주소 붙여넣기!
//         url: "",
//         data: {
//             // "키값" : 변수명
//             "pageNumber" : page,
//             "category" : category,
//             "subCategory" : subCategory,
//             "searchText" : searchText
//         },
//         dataType: "json",
//         success: (response) => {
//             console.log(response);
//             if(response.data.length != 0){
//                 // 페이징 처리 할 때
//                 loadPageNumberButtons(response.data[0].faqTotalCount);
//                 // innerHTML에서 list추가
//                 addFaqLists(response.data);
//             }else{
//                 alert("검색 결과가 없습니다.");
//             }
            
//         },
//         error: (error) => {
//             console.log(error);
//         }
//     });
// }

// // innerHTML 만들어야 될 거같은데.....이렇게 하는게 맞나요...ㅜㅜ?
// function addFaqLists(faqList){

//     const listBody= document.querySelector(".faq-list-page");

//     listBody.innerHTML="";

//     faqList.forEach((faq, index) => {

//         listBody.innerHTML += `
        
//         <ul>
//         <li class="faq-list-header">
//             <dl>
//                 <!-- ${category} -->
//                 <dt>후원</dt>
//                 <dd>
//                     <!-- ${subCategory}
//                     <span>[개인후원]</span> -->
//                     <!-- ${question}-->
//                     <p>유니세프는 무엇이 다른가요?</p>
//                 </dd>
//             </dl>
//                 <i class="fa-solid fa-circle-arrow-down"></i>
//         </li>
//         <!-- ${questionDetail} -->
//         <div class="faq-detail detail-invisible">
//             <p>
//                 1. 유니세프는 신뢰할 수 있습니다.<br>
//                 유엔 기관이기 때문입니다. 유엔아동권리협약에 직접 명시된 유일한 아동권리증진 기관이자 1965년에 노벨평화상도 수상했습니다.
//             </p>
//             &nbsp
            
//             <p>
//                 2. 유니세프는 같은 돈으로 더 많은 어린이를 구합니다.<br>
//                 유니세프는 지난 75년간의 경험과 전문성을 가지고 있으며 구호물품 등을 대량 구매하며 각국 정부와 협력해 근본적인 문제 해결을 추구하기 때문입니다.
//             </p>
//             <p>&nbsp</p>
            
//             <P>
//                 3. 유니세프는 재난 발생시 가장 먼저 현장에 접근합니다.<br>
//                 유니세프는 약 190개 나라와 영토에서 활동하며, 5개의 물류센터를 보유해 전 세계 어디서 재난이 발생해도 가장 신속하게 현장에 접근하여 어린이를 돕습니다. 긴급상황이 종료된 후에도 한결같이 어린이 곁을 지키며 지속가능한 발전을 지원합니다.
//             </P>
//             <p>&nbsp</p>
            
//             <p>
//                 4. 유니세프는 효율적이고 투명합니다.<br>
//                 유니세프한국위원회는 후원금 100원 중 85원을 어린이들을 위해 유니세프 본부로 송금하여, 전 세계 33개 유니세프국가위원회 중 가장 높은 송금율을 자랑합니다. 유니세프한국위원회는 국내 평가 전문 기관으로부터 높은 효율성과 투명성도 인정받고 있습니다. 
//             </p>
//             <p>&nbsp</p>

//             <p>
//             ※ 유니세프한국위원회의 효율성과 투명성에 대한 객관적 증거<br>
//             &nbsp ① 유니세프한국위원회는 독립적인 국내평가 기관이 실시한 공익법인 재무 종합평가에서 재무 안정성 및 효율성, 투명성 및 책무성 종합평가에서 만점인 별3개와 크라운 인증을 2019~2020년 2년 연속 획득했습니다.<br>
//             &nbsp ② 특히 2020년에는 20개 세부항목 평가에서도 모두 만점을 받았습니다. 이 3가지 사항을 모두 충족한 법인은 평가 대상 9,648곳 중 유니세프한국위원회를 포함해 4곳(0.04%)에 불과합니다.
//             </p>
//             <p>&nbsp</p>
            
//             </p>
//                 5. 우리가 도움을 줄 차례입니다.<br>
//                 유니세프는 1950년부터 1993년까지 43년간 수많은 한국 어린이의 소중한 생명을 지켰습니다. 이제는 우리가 개발도상국 어린이들에게도 꿈꿀 기회를 주어야 합니다.
//             </p>
//             <p>&nbsp</p>
            
//             ※ 지난 75년 간 한국이 유니세프에서 세운 세 가지 기록<br>
//             &nbsp   ① 첫째, 유니세프 역사상 한국은 도움을 받다가 도움을 주는 나라로 전환한 유일한 국가입니다.<br>
//             &nbsp    ② 둘째, 한국은 1994년 유니세프한국위원회 설립 이후 2020년에는 미국, 일본, 독일, 영국과 함께 5대 모금대국으로 성장했습니다.<br>
//             &nbsp    ③ 셋째, 유니세프한국위원회는 전 세계 33개 국가위원회 중 가장 높은 효율성을 보이고 있습니다.<br>
//             &nbsp    ④ 한 마디로, 한국은 왜 유니세프가 존재하는지 입증해 줍니다.<br>
//         </div>
    
//     </ul>


//         `


//     })


//  // Event Toggle

// const detailLists = document.querySelectorAll(".faq-list-header");
// const faqDetails = document.querySelectorAll(".faq-detail")

//     detailLists.forEach((detailList, index) => {
//         detailList.onclick = () => {
//             faqDetails.forEach((faqDetail, index2) => {
//                 if(index2 != index){
//                     faqDetail.classList.add("detail-invisible");
//                 }

//             })
//             faqDetails[index].classList.toggle("detail-invisible");
//         }
// });


// }




 $(function(){
    $('.faq-list-header > dl').click(function(){
        // 리스트 글자를 클릭했을 때
        if($(this).siblings().hasClass("invisible") === false){
            // 만약에 상세 페이지가 있다면
            $(this).siblings().addClass('invisible');
            // 상세 페이지를 닫고
        }else{ 
            $('.faq-list-header .faq-detail').addClass('invisible');
            // 상세페이지를 닫으면
            $(this).siblings().removeClass('invisible');
            // 상세페이지를 보이지 않게 하라
        }
    });
 });