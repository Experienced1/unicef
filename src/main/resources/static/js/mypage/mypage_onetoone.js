const submitButton = document.querySelector(".submit-button");
// const onetooneInput = document.querySelector(".onetoone-input");
// const cancelButton = document.querySelector(".cancel-button");

submitButton.onclick = () => {
    let formData = new FormData();

    formData.append("category", null);
    formData.append("onetoone_writer", null);
    formData.append("title", $('input[class=onetoone-input-title]').val());
    formData.append("detail", document.querySelector(".onetoone-input-detail").value);

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





// $(function(){
//     $('.private-donate-btn').click(function(){
//         $(this).addClass('active');
//         console.log('개인후원 click');
//     });
// });