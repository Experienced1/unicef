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
                        <dt><input type="text" class="notice-input-title" value="${notice.notice_title}">${notice.attachedFileList[0].file_origin_name}</dt>
                    </p> 
                </dt>
                <dd>
                    <!-- date -->
                    ${notice.create_date}
                </dd>
                    
            </dl>
                
                <!-- questionDetail -->
            <div class="notice-detail detail-invisible invisible">
                <textarea class="notice-input-detail">${notice.notice_detail}</textarea>
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

    // 수정
    const updateButton = document.querySelectorAll('.update-button');
    const idInput = document.querySelectorAll('.notice-input-id');
    const titleInput = document.querySelectorAll('.notice-input-title');
    const detailInput = document.querySelectorAll('.notice-input-detail');
    
    let notice = null;
    
    for(i=0; i<updateButton.length; i++){        
        updateButton[i].onclick = () => {
            
            notice = {
                "id": $('input[class=notice-input-id]').val(),
                "notice_title": $('input[class=notice-input-title]').val(),
                "notice_detail": $('textarea[class=notice-input-detail]').val()
            }

            if(confirm("수정하시겠습니까?")){
                updateRequest(notice);
            }else{
                alert("공지사항 수정이 취소되었습니다");
            }
            
        }
        
    }

    function updateRequest(notice) {

        $.ajax({
            async: false,
            type: "put",
            url: "/api/admin/notice/modification",
            contentType: "application/json",
            data: JSON.stringify(notice),
            dataType: "json",
            success: (response) => {
                alert("공지사항 수정 완료");
                location.reload();
            },
            error: (error) => {
                alert("공지사항 수정 실패");
                console.log(error);
            }
        });
    }

    // 삭제
    const deleteButton = document.querySelectorAll(".delete-button");

    for(i=0; i < deleteButton.length; i++){
        
        deleteButton[i].onclick = () => {
            
            notice = {
                "id": $('input[class=notice-input-id]').val(),
                "notice_title": $('input[class=notice-input-title]').val(),
                "notice_detail": $('textarea[class=notice-input-detail]').val()
            }
            if(confirm("삭제하시겠습니까?")){
                deleteRequest(notice);
            }else{
                alert("공지사항 삭제가 취소되었습니다");
            }
        
        }
    }

    function deleteRequest(id) {
        $.ajax({
            async: false,
            type: "delete",
            url: "/api/admin/notice/" + id.id,
            dataType: "json",
            success: (response) => {
                alert("공지사항 삭제 완료!");
                location.reload();
            },
            error: (error) => {
                alert("공지사항 삭제 실패!");
                console.log(error);
            }
        });
    }

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