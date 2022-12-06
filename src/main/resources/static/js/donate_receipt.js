
//콤마찍기
function comma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}

//년월일
function datekr(date) {
    date = String(date);
    date = date.replace("-", "년 ")
    date = date.replace("-", "월 ")
    date = date + "일";
    return date;
}


//금액 한글화
function getAmountKorean() {
    var args = arguments;
    var arrDigit1 = Array('', '일', '이', '삼', '사', '오', '육', '칠', '팔', '구');
    var arrDigit3 = Array('', '십', '백', '천');
    var arrDigit4 = Array('', '만', '억', '조', '경', '해', '자', '양', '구', '간', '정', '재', '극');
    var digitIdx = 0;  //자릿수
    var digit4Idx = 0;  //arrDigit4의 index
    var digit4Rest = 0;  //4로 나눈 나머지
    var digit4Used = false;  //arrDigit4 사용여부
    var rslt = '';  //결과
    amt = args[0];
    amt = amt.toString().replace(/[^\d\.]/g, '').replace(/\.\d+$/g, '');

    for(var idx = amt.length - 1; idx >= 0; idx--) {
        digit4Rest = digitIdx%4;
        
        if(digitIdx && !digit4Rest) {
            digit4Idx++;
            digit4Used = false;
        }

        if(amt[idx] > 0) {
            if(!digit4Used) {
                rslt = arrDigit4[digit4Idx] + rslt;
                digit4Used = true;
            }
            rslt = arrDigit3[digit4Rest] + rslt;
            rslt = arrDigit1[amt[idx]] + rslt;
        }
        digitIdx++;
    }
    return rslt + '원';
}


$(function(){
    let principal = getPrincipal();
    userName = principal.user.user_name;

    const spReceipt = document.querySelector(".sp-receipt");
    let mylistReceipt = JSON.parse(localStorage.getItem("mylistReceipt"));
    
    console.log(JSON.stringify(mylistReceipt));
    localStorage.removeItem("mylistReceipt");

    // 회원정보
        createDate = mylistReceipt.createDate.substr(0, 10); 
        donateAmount = mylistReceipt.donateAmount;

        spReceipt.innerHTML = `
            <h1>영　수　증</h1>
            <div class="sp-receipt1">
                ${userName} 귀중 <br>
                일금:${getAmountKorean(donateAmount)}(￦${comma(donateAmount)})
            </div>

            <div class="sp-receipt2">
                위의 금액을 유니세프한국위원회 기부금으로 정히 영수함
                <p>${datekr(createDate)}</p>
            </div>

            <div class="sp-receipt3">
                (사)유니세프한국위원회
                <p>
                    서울 종로구 창성동 17-1 <br>
                    고유번호 102-82-07606
                </p>
            </div>
            <img src="/static/images/donate/stamp.JPG" alt="stamp">
        `;

    
});



