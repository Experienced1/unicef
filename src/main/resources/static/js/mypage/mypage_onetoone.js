const submitButton = document.querySelector(".submit-button");
const onetooneInputDetail = document.querySelector(".onetoone-input-detail");
// const cancelButton = document.querySelector(".cancel-button");

let formData = new FormData();

// 클릭시 활성화
$(function(){
    formData.append('category', "개인후원");
    $('.onetoone-btn > button').click(function(){
        $(this).addClass('mypage-active').siblings().removeClass('mypage-active');
        formData.delete('category');
        formData.append("category",$(this).val());
        formData.delete("onetoone_writer");
        formData.delete("title");
        formData.delete("detail");
    });
 });

submitButton.onclick = () => {
    formData.append("onetoone_writer", "홍길동");
    formData.append("title", $('input[class=onetoone-input-title]').val());
    formData.append("detail", onetooneInputDetail.value);

    request(formData);
}

function request(formData) {
    $.ajax({
        async: false,
        type: "post",
        url: "/api/mypage/onetoone",
        enctype: "multipart/form-data",
        contentType: false,
        processData: false,
        data: formData,
        dataType: "json",
        success: (response) => {
            alert("1:1 문의 등록 완료");
            console.log(response);
        },
        error: (error) => {
            alert("1:1 문의 등록 실패");
            console.log(error);
        }
    });
}





