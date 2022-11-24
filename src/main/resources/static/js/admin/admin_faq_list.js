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
                <button type="button" class="button white-button">
                    수정
                </button>
                <button type="button" class="button white-button">
                    삭제
                </button>
                <dt>${faq.category}</dt>
                <dd>
                    <p>${faq.faq_title}</p>
                    <i class="fa-solid fa-circle-arrow-down"></i>
                </dd>
            </dl>
            <div class="faq-detail detail-invisible invisible">
                <p>${faq.faq_detail}</p>
            </div>
        </li>
        `;
    });
}