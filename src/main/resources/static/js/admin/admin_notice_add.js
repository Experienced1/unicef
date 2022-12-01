const submitButton = document.querySelector(".submit-button");
const noticeInputTitle = document.querySelector(".notice-input-title");
const noticeInputDetail = document.querySelector(".notice-input-detail");

let formData = new FormData();

submitButton.onclick = () => {
    formData.append("notice_title", noticeInputTitle.value);
    formData.append("notice_detail", noticeInputDetail.value);

    request(formData);
}

function request(formData) {
    $.ajax({
        async: false,
        type: "post",
        url: "/api/admin/notice",
        enctype: "multipart/form-data",
        contentType: false,
        processData: false,
        data: formData,
        dataType: "json",
        success: (response) => {
            alert("새 공지사항 등록 완료");
            console.log(response);
        },
        error: (error) =>{
            alert("새 공지사항 등록 실패");
            console.log(error);
        }
    });
}