var totalDonate = $('.donate1-4 .total-donate'); // 총액
var headerMid = document.querySelector(".header-mid");
var donateArea = null; // 후원분야선택
var donateAmount = null;// 후원금액
var donateType = null; // 후원종류
var donateName = null; // 후원자 성명
var userBirthdate = null; // 후원자 생년월일


// 후원 헤더 관리 //// 후원 헤더 관리 //
$(function(){
    $('.header-logo').click(function(){
        location.href = '/templates/donate.html';
    });
});

// 스크롤 이동에 따른 헤더 변형 //
$(window).scroll(function(){
    $('.header-mid').css('left', 0-$(this).scrollLeft());

    const scrollP = $(window).scrollTop();
    
    if(scrollP > 50){
        headerMid.style.top = "0px";       
    }else{
        headerMid.style.top = "50px";     
    }
});

// 스텝 단계 이동 btn //
$(function(){
    $('.next-button').click(function(){
    //다음버튼 클릭시 //
        var liIndex = $(this).closest('li').index();

        if(liIndex < 3){
            $('.donate-content-auto > li:eq('+liIndex+')').addClass('invisible');
            
            $('html').scrollTop(0);
            $('.donate-content-auto > li:eq('+(liIndex + 1)+')').removeClass('invisible');
        }

    // 선택정보 명시 //
        // 후원방법sponsorship
        donateArea = $("select[name=sponsorship]").val(); // 후원분야
        donateAmount = totalDonate.html();
        donateType = $(".first-step .donate1-1 button.active").html() + '후원';
        $('.step1-summary').html(donateArea + '/' + donateAmount + '/' + donateType);

        // 후원자정보
        donateName = $('.donate2-1 > div:nth-child(2) > input').val();
        var userbirth = $('.donate2-1 > div:nth-child(4) > input').val();
        $('.step2-summary').html(donateName + '/' + userbirth);

    });

    $('.prev-button').click(function(){
        //변경버튼 클릭시
        var liIndex = $(this).closest('li').index();
        var prevIndex = $(this).closest('div.inactive-step').index();

        $('.donate-content-auto > li:eq('+liIndex+')').addClass('invisible');
        $('html').scrollTop(0);
        $('.donate-content-auto > li:eq('+(prevIndex - 1)+')').removeClass('invisible');
    });
 });

// 1.first-step //// 1.first-step //
// 정기+일시 구분 btn //
$(function(){
    $('.first-step .pledge-btn').click(function(){
        //정기후원 클릭시
        $(this).addClass('active').siblings().removeClass('active');
        $('.first-step .donate1-3-pledge').removeClass('invisible');
        $('.first-step .donate1-3-oneoff').addClass('invisible');

        $('.donate1-4 > span > strong').html('30,000');
    });
    
    $('.first-step .oneoff-btn').click(function(){
        //일시후원 클릭시
        $(this).addClass('active').siblings().removeClass('active');
        $('.first-step .donate1-3-oneoff').removeClass('invisible');
        $('.first-step .donate1-3-pledge').addClass('invisible');

        $('.donate1-4 > span > strong').html('50,000');    });
 });


// 후원금액 btn //
$(function(){
    //정기_후원금액(원) 클릭시
    $('.donate1-3-pledge .text-button').keyup(function(){
        totalDonate.html($('.donate1-3-pledge .text-button').val());
    })

    $('.first-step .donate1-3-pledge input').click(function(){
        $(this).addClass('active').siblings().removeClass('active');
        $('.text-button').removeClass('active');

        var pledgePick = $('.donate1-3-pledge strong:nth-child(1)').html($(this).val());

        if($(this).val() == '30,000'){
            $('.donate1-3-pledge strong:nth-child(2)').html('홍역 예방백신 720회분');
        }else if($(this).val() == '50,000'){
            $('.donate1-3-pledge strong:nth-child(2)').html('소아마비 예방백신 6,000회분');
        }else if($(this).val() == '100,000'){
            $('.donate1-3-pledge strong:nth-child(2)').html('태양광램프 34개');
        }else if($(this).val() == '200,000'){
            $('.donate1-3-pledge strong:nth-child(2)').html('공책 4,800권');
        }else if($(this).val() == '300,000'){
            $('.donate1-3-pledge strong:nth-child(2)').html('소아마비 예방백신 18,000회분');
        }else{
            $('.donate1-3-pledge strong:nth-child(1)').html($(this).val()+'원');
            $('.donate1-3-pledge strong:nth-child(2)').html('소아마비 예방백신 18,000회분');
        }
        
        //총액
        totalDonate.html($(this).val());
    });

    //일시_후원금액(원) 클릭시    
    $('.donate1-3-oneoff .text-button').keyup(function(){
        totalDonate.html($('.donate1-3-oneoff .text-button').val());
    })
    
    $('.first-step .donate1-3-oneoff input').click(function(){
        $(this).addClass('active').siblings().removeClass('active');
        $('.text-button').removeClass('active');

        //총액
        totalDonate.html($(this).val());
    });
 });
 
 
// 2.second-step //// 2.second-step //
// 기부금 영수증 chk-box btn //
$(function(){
    $('#chk_box').click(function(){
        if($('.donate2-1-receipt > div').hasClass('invisible')){
            $('.donate2-1-receipt > div').removeClass('invisible');
        }else{
            $('.donate2-1-receipt > div').addClass('invisible');
        }

    })
 });

// 3.third-step //// 3.third //
// 신용카드+무통장입금+네이버페이 구분 btn //
$(function(){
    $('.donate3-1 button').click(function(){
        //정기후원 클릭시
        $(this).addClass('active').siblings().removeClass('active');
    });

 });

 // 금액 숫자 컴마 제거 //
function minusComma(value){
    value = String(value).replace(/[^\d]+/g, "");
    return Number(value); 
}


//   import 결제API ----------------------------------------------------------------- //

const submitButton = document.querySelector("#submit-button");

var IMP = window.IMP; // 생략 가능
IMP.init("imp04038076"); // 예: imp00000000

submitButton.onclick = () => {
    if(donateType == "정기후원"){
        alert("정기후원");
        donatePledge();
    }else if(donateType == "일시후원"){
        donateOneoff();
    }else{
        alert("에러!")
    }
}


// 정기결제 api
function donatePledge(){    
    // IMP.request_pay(param, callback) 결제창 호출
    IMP.request_pay({ // param
        customer_uid: "gildong_0001_1234", // 카드(빌링키)와 1:1로 대응하는 값
        schedule_at: 1519862400, // 결제 시도 시각 in Unix Time Stamp. 예: 다음 달 1일
        pg: "danal_tpay",
        pay_method: "card",
        merchant_uid: "ORD32320280131-00e0ssd395", // 주문번호
        name: donateType, // 결제정보(상품명)
        amount: donateAmount, // 후원금액
        // buyer_email: "gildoneg@gmail.com",
        buyer_name: donateName, // 후원자 이름
        buyer_tel: "010-0000-0000"
    }, function (rsp) { // callback
        if (rsp.success) {
            console.log('빌링키 발급 성공', rsp);
            donateInfoData();
            alert("예약 결제가 완료되었습니다!");
            //후원성공 팝업 띄우기
            //location.replace("/account/login"); //이전기록 날려야함.
        } else {
            var msg = '결제에 실패했습니다. \n';
            msg += rsp.error_msg
            alert(msg);            
            return false;
        }
    });
}

// 일시결제 api
function donateOneoff(){    
    // IMP.request_pay(param, callback) 결제창 호출
    IMP.request_pay({ // param
        pg: "html5_inicis", // "kakaopay", // pg사 선택
        pay_method: "card",
        merchant_uid: "ORD32320280131-00e0ssd395", // 주문번호
        name: donateType, // 결제정보(상품명)
        amount: donateAmount, // 후원금액
        // buyer_email: "gildoneg@gmail.com",
        buyer_name: donateName, // 후원자 이름
        buyer_tel: "010-0000-0000"
    }, function (rsp) { // callback
        if (rsp.success) {
            console.log('빌링키 발급 성공', rsp);
            donateInfoData();
            alert("예약 결제가 완료되었습니다!");
            //후원성공 팝업 띄우기
            //location.replace("/account/login"); //이전기록 날려야함.
        } else {
            var msg = '결제에 실패했습니다. \n';
            msg += rsp.error_msg
            alert(msg);            
            return false;
        }
    });
}

// ajax로 보내야 하는 데이터
 function donateInfoData(){    
    let donateInfo = {
        donateName: donateName, //후원자이름     
        donateArea: donateArea, //후원분야
        donateAmount: minusComma(donateAmount), //후원금액    
        donateType: donateType // 후원종류
    }

    $.ajax({
        async: false,
        type: "post",
        url: "/api/donate",
        contentType: "application/json",
        data: JSON.stringify(donateInfo),
        dataType: "json",
        success: (response) => {
            console.log(response);
        },
        error: (error) => {
            alert(error);
            console.log(error);
            //후원실패 팝업 띄우기
            // validationError(error.responseJSON.data);
        }
    })
}