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
            ${noticeList[0].create_date}
        </dd>
            
    </dl>
        
    <div class="notice-detail detail-invisible">
        ${noticeList[0].notice_detail}
    </div>
    <div>
        <strong>첨부파일</strong>
    </div>
    <div>
        <a href="/download/notice?originFileName=${noticeList[0].attachedFileList[0].file_origin_name}&tempFileName=${noticeList[0].attachedFileList[0].file_temp_name}">${noticeList[0].attachedFileList[0].file_origin_name}</a>
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
            <a href="" class="notice-title-prev">${noticeList[1].notice_title}</a>
            <p>${noticeList[1].create_date}</p>
        </div>
        <div class="prevnext">
            <i class="fa-solid fa-chevron-down"></i>
            <p>다음글</p>
            <a href="" class="notice-title-next">${noticeList[2].notice_title}</a>
            <p>${noticeList[2].create_date}</p>
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