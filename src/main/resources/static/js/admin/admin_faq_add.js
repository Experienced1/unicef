const submitButton = document.querySelector(".submit-button");
const faqInputTitle = document.querySelector(".faq-input-title");
const faqInputDetail = document.querySelector(".faq-input-detail");

let formData = new FormData();

submitButton.onclick = () => {
    formData.append("category", $('select[class=category]').val());
    formData.append("faq_title", faqInputTitle.value);
    formData.append("faq_detail", faqInputDetail.value);

    request(formData);
}

function request(formData) {
    $.ajax({
        async: false,
        type: "post",
        url: "/api/admin/faq",
        enctype: "multipart/form-data",
        contentType: false,
        processData: false,
        data: formData,
        dataType: "json",
        success: (response) => {
            alert("새 FAQ 등록 완료");
            console.log(response);
        },
        error: (error) =>{
            alert("새 FAQ 등록 실패");
            console.log(error);
        }
    });
}