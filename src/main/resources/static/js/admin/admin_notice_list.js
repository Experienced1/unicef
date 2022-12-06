window.onload = () => {
    getList();
}

function getList(){
    $.ajax({
        async: false,
        type: "get",
        url: "/api/admin/noticeList",
        contentType: "application/json",
        data: JSON.stringify(),
        dataType: "json",
        success: (response) => {
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
    const listBody = document.querySelector(".notice-list-body");

    listBody.innerHTML = "";

    noticeList.forEach((notice) => {

        listBody.innerHTML += `
        <li class="notice-list-header">
            <dl>
                <dt>
                        <!-- question-->
                    <p>
                        <button type="button" class="button white-button modify-button">
                            수정
                        </button>
                        <button type="button" class="button white-button delete-button">
                            삭제
                        </button>
                        <input type="hidden" class="notice-input-id" value="${notice.notice_id}">
                        <dt><input type="text" class="notice-input-title" value="${notice.notice_title}"></dt>
                    </p> 
                </dt>
                <dd>
                    <!-- date -->
                    ${notice.update_date}
                </dd>
                    
            </dl>
                
                <!-- questionDetail -->
            <div class="notice-detail detail-invisible invisible">
                <textarea class="notice-input">${notice.notice_detail}</textarea>
                <button type="button" class="black-button update-button">수정하기</button>
                
            </div>
            
            
            
        </li>
        `
    });

    listBody.innerHTML += 
    `<div>
        <div class="list-button-wrap">
            <a href="#">
                <button type="button" class="button list-button">목록</button>
            </a>
        </div>
    </div>`;

    // 상세페이지 클릭
    $('.notice-list-header > dl').click(function(){
        // 리스트 글자를 클릭했을 때
        if($(this).siblings().hasClass("invisible") === false){
            // 만약에 상세 페이지가 있다면
            $(this).siblings().addClass('invisible');
            // 상세 페이지를 닫고
        }else{ 
            $('.notice-list-header .notice-detail').addClass('invisible');
            // 상세페이지를 닫으면
            $(this).siblings().removeClass('invisible');
            // 상세페이지를 보이지 않게 하라
        }
    });
}