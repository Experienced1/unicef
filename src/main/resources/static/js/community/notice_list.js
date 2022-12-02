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
    const listBody = document.querySelector(".notice-list-body");

    listBody.innerHTML = "";

    noticeList.forEach((notice) => {
        
        listBody.innerHTML += `
        <li class="notice-list-header">
            <div >
                <dl>
                    <dt>
                        <a href="/community/noticeMain/item">${notice.notice_title}</a>
                    </dt>
                    <dd>
                        ${notice.update_date}
                    </dd>
                    
                </dl>
            </div>
            <div class="notice-detail detail-invisible invisible">
                <p>${notice.notice_detail}</p>
            </div>
        </li>
        `;
    });


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