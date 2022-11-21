const submitButton = document.querySelector(".submit-button");
const onetooneInputDetail = document.querySelector(".onetoone-input-detail");
// const cancelButton = document.querySelector(".cancel-button");

let formData = new FormData();

// 클릭시 활성화
$(function(){
    $('.onetoone-btn > button').click(function(){
        $(this).addClass('mypage-active').siblings().removeClass('mypage-active');
    });
 });

// 개인후원 버튼클릭
$(function(){
    $('.private-donate-btn').click(function(){
        formData.append("category", document.getElementById("개인후원").value);
    });
});

// 팔찌,반지 버튼클릭
$(function(){
    $('.bracelet-btn').click(function(){
        formData.append("category", document.getElementById("팔찌,반지").value);
    });
});

// 홍보,자료문의 버튼클릭
$(function(){
    $('.promotion-btn').click(function(){
        formData.append("category", document.getElementById("홍보,자료문의").value);
    });
});

// 자원봉사 버튼클릭
$(function(){
    $('.volunteer-btn').click(function(){
        formData.append("category", document.getElementById("자원봉사").value);
    });
});

// 채용 버튼클릭
$(function(){
    $('.recruit-btn').click(function(){
        formData.append("category", document.getElementById("채용").value);
    });
});

// 아동권리·아동친화사업 버튼클릭
$(function(){
    $('.kids-right-btn').click(function(){
        formData.append("category", document.getElementById("아동권리·아동친화사업").value);
    });
});

// 학교캠페인 버튼클릭
$(function(){
    $('.school-campaign-btn').click(function(){
        formData.append("category", document.getElementById("학교캠페인").value);
    });
});

// 모유수유 버튼클릭
$(function(){
    $('.mothermilk-btn').click(function(){
        formData.append("category", document.getElementById("모유수유").value);
    });
});

// 기업후원 버튼클릭
$(function(){
    $('.company-donate-btn').click(function(){
        formData.append("category", document.getElementById("기업후원").value);
    });
});

// 기념기부 버튼클릭
$(function(){
    $('.anniversary-btn').click(function(){
        formData.append("category", document.getElementById("기념기부").value);
    });
});

// 동전모금 버튼클릭
$(function(){
    $('.coin-funding-btn').click(function(){
        formData.append("category", document.getElementById("동전모금").value);
    });
});

// 후원병원 버튼클릭
$(function(){
    $('.hospital-btn').click(function(){
        formData.append("category", document.getElementById("후원병원").value);
    });
});

// 유산기부 버튼클릭
$(function(){
    $('.legacy-btn').click(function(){
        formData.append("category", document.getElementById("유산기부").value);
    });
});

// 재단/비영리/기관 및 단체 버튼클릭
$(function(){
    $('.foundation-btn').click(function(){
        formData.append("category", document.getElementById("재단/비영리/기관 및 단체").value);
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





