window.onload = () => {
    getList();
}

function getList() {
    $.ajax({
        async: false,
        type: "get",
        url: "/api/admin/faqList",
        contentType: "application/json",
        data: JSON.stringify(),
        dataType: "json",
        success: (response) => {
            console.log(response);
            showFaqList(response.data);
        },
        error: (error) => {
            alert("실패");
            console.log(error);
        }
    });
}

function showFaqList(faqList){
    console.log("ddddddddddddddddd" + faqList);
    const listBody = document.querySelector(".faq-list-body");

    listBody.innerHTML = "";

    faqList.forEach((faq) => {
        
        listBody.innerHTML += `
        <li class="faq-list-header">
            <dl>
                <button type="button" class="button white-button modify-button">
                    수정
                </button>
                <button type="button" class="button white-button delete-button">
                    삭제
                </button>
                <input type="hidden" class="faq-input-id" value="${faq.id}">
                <dt>
                    <div class="category">
                        <input type="text" class="faq-input-category" value="${faq.category}" placeholder="카테고리" style="width:300px;height:100px;font-size:20px;"></dt>
                    </div>
                <dd>
                    <div class="title">
                        <input type="text" class="faq-input-title" value="${faq.faq_title}" placeholder="문의 제목" style="width:750px;height:100px;font-size:20px;">
                    </div>
                    <i class="fa-solid fa-circle-arrow-down"></i>
                </dd>
            </dl>
            <div class="faq-detail detail-invisible invisible">
                <div class="detail">
                    <textarea class="faq-input" placeholder="문의 내용" style="width:750px;height:300px;font-size:20px;">${faq.faq_detail}</textarea>
                </div>
                <button type="button" class="black-button update-button">수정하기</button>
            </div>



            <!-- 
            <div class="faq-modify invisible">
                <td colspan="8">
                    <table class="faq-info">
                        <tr>
                            <td><input type="text" class="faq-input-category" value="${faq.category}" placeholder="카테고리"></td>
                            <td><input type="text" class="faq-input-title" value="${faq.faq_title}" placeholder="문의 제목"></td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <textarea class="faq-input" placeholder="문의 내용">${faq.faq_detail}</textarea>
                            </td>
                        </tr>
                        
                        
                        <tr>
                            <td colspan="3">
                                <button type="button" class="black-button update-button">수정하기</button>
                            </td>
                        </tr>
                    </table>
                </td>
            </div>
            -->



        </li>
        `;

    });

    // 수정
    const updateButton = document.querySelectorAll('.update-button');
    const idInput = document.querySelectorAll('.faq-input-id');
    const categoryInput = document.querySelectorAll('.faq-input-category');
    const titleInput = document.querySelectorAll('.faq-input-title');
    const detailInput = document.querySelectorAll('.faq-input-detail');
    
    let faq = null;
    
    for(i=0; i<updateButton.length; i++){        
        updateButton[i].onclick = () => {
            
            faq = {
                "id": $('input[class=faq-input-id]').val(),
                "category": $('input[class=faq-input-category]').val(),
                "faq_title": $('input[class=faq-input-title]').val(),
                "faq_detail": $('textarea[class=faq-input]').val()
            }

            if(confirm("수정하시겠습니까?")){
                updateRequest(faq);
            }else{
                alert("FAQ 수정이 취소되었습니다");
            }
            
        }
        
    }

    function updateRequest(faq) {

        $.ajax({
            async: false,
            type: "put",
            url: "/api/admin/faq/modification",
            contentType: "application/json",
            data: JSON.stringify(faq),
            dataType: "json",
            success: (response) => {
                alert("FAQ 수정 완료");
                location.reload();
            },
            error: (error) => {
                alert("FAQ 수정 실패");
                console.log(error);
            }
        });
    }

    // 삭제
    const deleteButton = document.querySelectorAll(".delete-button");

    for(i=0; i < deleteButton.length; i++){
        
        deleteButton[i].onclick = () => {
            
            faq = {
                "id": $('input[class=faq-input-id]').val(),
                "category": $('input[class=faq-input-category]').val(),
                "faq_title": $('input[class=faq-input-title]').val(),
                "faq_detail": $('textarea[class=faq-input]').val()
            }
            if(confirm("삭제하시겠습니까?")){
                deleteRequest(faq);
            }else{
                alert("FAQ 삭제가 취소되었습니다");
            }
        
        }
    }

    function deleteRequest(id) {
        $.ajax({
            async: false,
            type: "delete",
            url: "/api/admin/faq/" + id.id,
            dataType: "json",
            success: (response) => {
                alert("FAQ 삭제 완료!");
                location.reload();
            },
            error: (error) => {
                alert("FAQ 삭제 실패!");
                console.log(error);
            }
        });
    }

    // 상세페이지 클릭
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
}

