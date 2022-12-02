window.onload = () => {
    getList();
}

function getList() {
    $.ajax({
        async: false,
        type: "get",
        url: "/api/admin/noticeList",
        contentType: "application/json",
        data: JSON.stringify(),
        dataType: "json",
        success: (response) => {
            console.log(response);
            showNoticeList(response.data);
        },
        error: (error) => {
            alert("실패");
            console.log(error);
        }
    });
}

function showNoticeList(noticeList){
    console.log(noticeList);
    const listBody = document.querySelector(".notice-list-header");

    listBody.innerHTML = "";

    listBody.innerHTML += `
    <dl>
        <dt>
            <p><a href="" class="notice-title">${noticeList[0].notice_title}</a></p> 
        </dt>
        <dd>
            ${noticeList[0].update_date}
        </dd>
            
    </dl>
        
    <div class="notice-detail detail-invisible">
        ${noticeList[0].notice_detail}
    </div>
    <div>
        <div class="list-button-wrap">
            <button type="button" class="button list-button">
                <a href="/community/noticeMain">목록</a>
            </button>
        </div>
    </div>
    <div>
        <div class="prevnext">
            <i class="fa-solid fa-chevron-up"></i>
            <p>이전글</p>
            <a href="" class="notice-title-prev">유니세프한국위원회 팩트 체크 “유니세프, 믿을 수 있나요”</a>
            <p>2022.08.25</p>
        </div>
        <div class="prevnext">
            <i class="fa-solid fa-chevron-down"></i>
            <p>다음글</p>
            <a href="" class="notice-title-next">유니세프한국위원회 팩트 체크 “유니세프, 믿을 수 있나요”</a>
            <p>2022.08.25</p>
        </div>
    </div>
    `;


    $('.notice-list-header > dl').click(function(){
        // // 리스트 글자를 클릭했을 때
        // if($(this).siblings().hasClass("invisible") === false){
        //     // 만약에 상세 페이지가 있다면
        //     $(this).siblings().addClass('invisible');
        //     // 상세 페이지를 닫고
        // }else{ 
        //     $('.notice-list-header .notice-detail').addClass('invisible');
        //     // 상세페이지를 닫으면
        //     $(this).siblings().removeClass('invisible');
        //     // 상세페이지를 보이지 않게 하라
        // }

    });

    
}