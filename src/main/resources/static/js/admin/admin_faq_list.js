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
                <dt><input type="text" class="faq-input" value="${faq.category}" placeholder="카테고리"></dt>
                <dd>
                    <input type="text" class="faq-input" value="${faq.faq_title}" placeholder="문의 제목">
                    <i class="fa-solid fa-circle-arrow-down"></i>
                </dd>
            </dl>
            <div class="faq-detail detail-invisible invisible">
                <textarea class="faq-input" placeholder="문의 내용">${faq.faq_detail}</textarea>
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

    // 수정
    const updateButton = document.querySelector('.update-button');
    
    let formData = new FormData();

    updateButton.onclick = () => {
        formData.append("category", $('input[class=faq-input-category]').val());
        formData.append("faq_title", $('input[class=faq-input-title]').val());
        formData.append("faq_detail", $('textarea[class=faq-input]').val());
        
        request(formData);
    }

    function request(formData) {
        $.ajax({
            async: false,
            type: "post",
            url: "/api/admin/faq/modification",
            enctype: "multipart/form-data",
            contentType: false,
            processData: false,
            data: formData,
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
}
