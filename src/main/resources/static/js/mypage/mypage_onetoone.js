const submitButton = document.querySelector(".submit-button");
// const onetooneInput = document.querySelector(".onetoone-input");
// const cancelButton = document.querySelector(".cancel-button");

submitButton.onclick = () => {
    let formData = new FormData();

    formData.append("category", null);
    formData.append("onetoone_writer", null);
    formData.append("title", $('input[class=onetoone-title]').val());
    formData.append("detail", $('input[class=onetoone-detail]').val());

    request(formData);
}

function request(formData) {
    $.ajax({
        async: false,
        type: "post",
        url: "/api/mypage/onetoone",
        enctype: "application/x-www-form-urlencoded",
        contentType: false,
        processData: false,
        data: formData,
        dataType: "json",
        success: (response) => {
            alert("1:1 문의 등록 완료");
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