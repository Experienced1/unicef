let totaldonateAmount = 0;
let myList = null;

//콤마찍기
function comma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}


$(function(){
    let principal = getPrincipal();
    
    userId = principal.user.user_id;
    userName = principal.user.user_name;

    myList = getmyList(userId);

    const mydataTotal = document.querySelector(".mydata-total");
    const mydataList = document.querySelector(".mydata-list");

    //회원목록
    mydataTotal.innerHTML = `
        <p>
            총 후원 횟수 <span>${myList.length}</span>번
        </p>
        <article>
            <div><i class="fa-solid fa-angles-left"></i></div>
            <div><i class="fa-solid fa-angle-left"></i></div>
            <div id="page-active">1</div>
            <div>2</div>
            <div>3</div>
            <div>4</div>
            <div>5</div>
            <div><i class="fa-solid fa-angle-right"></i></div>
            <div><i class="fa-solid fa-angles-right"></i></div>
        </article>
`;


    // 회원정보
    for(i=0; i < myList.length; i++){
        userId = myList[i].userId;
        createDate = myList[i].createDate.substr(0, 10);  
        donateArea = myList[i].donateArea;
        donateType = myList[i].donateType;
        donateAmount = myList[i].donateAmount;
        totaldonateAmount += myList[i].donateAmount;

        donateId = myList[i].donateId;


        mydataList.innerHTML += `
            <ul class="donateId-${donateId}">
                <li>${createDate}</li>
                <li>${donateArea}</li>
                <li>${donateType}</li>
                <li>${comma(donateAmount)}</li>
                <li>${comma(totaldonateAmount)}</li>
                <li class = "receipt-button">
                    <i class="fa-regular fa-pen-to-square"></i>
                </li>
                <li class = "delete-button">
                    <i class="fa-solid fa-minus"></i>
                </li>
            </ul>
        `;
    }

    
    $('.receipt-button').click(function(){
        var thisIndex = $(this).closest('ul').index();
        alert(thisIndex);
        receiptRequest(thisIndex);
    });
    
    $('.delete-button').click(function(){
        var thisDonateId = $(this).closest('ul').attr('class').substr(9);

        if(confirm("후원을 취소하시겠습니까?")){
            deleteRequest(thisDonateId);
        }else{
            alert("후원 취소가 요청되었습니다");
        }
    });
});

// 후원 영수증 요청
function receiptRequest(index) {
    let mylistReceipt = {
        createDate: myList[index].createDate.substr(0, 10),
        donateAmount: myList[index].donateAmount, //후원금액
        userId: myList[index].userId,
        donateArea: myList[index].donateArea,
        donateType: myList[index].donateType
    }

    localStorage.setItem("mylistReceipt", JSON.stringify(mylistReceipt));
    window.open('/mypage/supportinfo/mylist/receipt', '_blank');
}

// 후원 삭제 요청
function deleteRequest(id) {
    $.ajax({
        async: false,
        type: "delete",
        url: "/api/mypage/supportinfo/mylist/" + id,
        dataType: "json",
        success: (response) => {
            alert("후원 취소 완료!");
            location.reload();
        },
        error: (error) => {
            alert("후원 취소 실패!");
            console.log(error);
        }
    });
}