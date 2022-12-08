let userId = null;

$(function(){
    let userList = getUserList();

    const userdataTotal = document.querySelector(".userdata-total");
    const userdataList = document.querySelector(".userdata-list");
    const mydataTotal = document.querySelector(".mydata-total");
    const mydataList = document.querySelector(".mydata-list");

    //회원목록
    userdataTotal.innerHTML = `
        <p>
            전체 후원자 <span>${userList.length}</span>명
        </p>
`;


    // 회원정보
    for(i=0; i < userList.length; i++){
        userId = userList[i].userId;
        mainUsername = userList[i].mainUsername;
        oauthUsername = userList[i].oauthUsername;
        userProvider = userList[i].userProvider;
        userBirthdate = userList[i].userBirthdate;
        userEmail = userList[i].userEmail;
        userName = userList[i].userName;
        userPhone = userList[i].userPhone.replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-");
        createDate = userList[i].createDate.substr(0, 10);  
        totalAmount = userList[i].totalAmount;
        countDonate = userList[i].countDonate;

        userdataList.innerHTML += `
            <ul class="userId-${userId}">
                <li>${mainUsername}</li>
                <li>${userName}</li>
                <li>${userPhone}</li>
                <li>${userEmail}</li>
                <li>${createDate}</li>
                <li>${countDonate}</li>
                <li>${comma(totalAmount)}</li>
                <li class = "detail-button">
                    <i class="fa-regular fa-pen-to-square"></i>
                </li>
                <li class = "delete-button">
                    <i class="fa-solid fa-minus"></i>
                </li>
            </ul>
        `;
    }

    $('.detail-button').click(function(){
        $('.mydata').removeClass('invisible');
        var thisUserId = $(this).closest('ul').attr('class').substr(7);
        var thisIndex = $(this).closest('ul').index();
        
        myList = getmyList(thisUserId);
        
        userdataList
        
        userName = $('.userdata-list > ul:eq(' +thisIndex+ ') > li:nth-child(2)').text();

    // 개인회원정보
        mydataTotal.innerHTML = `
            <p>
                후원자 <span>${userName}</span>님
            </p>
            <p class="x-button">
                <i class="fa-solid fa-xmark"></i>
            </p>
        `;

        mydataList.innerHTML = "";

        if(myList.length != 0){
            for(i=0; i < myList.length; i++){
                createDate = myList[i].createDate.substr(0, 10);  
                donateArea = myList[i].donateArea;
                donateType = myList[i].donateType;
                donateAmount = myList[i].donateAmount;
    
                donateId = myList[i].donateId;
    
                mydataList.innerHTML += `
                    <ul class="donateId-${donateId}">
                        <li>${createDate}</li>
                        <li>${donateArea}</li>
                        <li>${donateType}</li>
                        <li>${comma(donateAmount)}</li>
                        <li class = "donate-delete">
                            <i class="fa-solid fa-minus"></i>
                        </li>
                    </ul>
                `;
            }
        }else{
            mydataList.innerHTML = `
                <ul>
                    <p>후원 내역이 없습니다.</p>
                </ul>
            `;
        }   

    //개인후원취소
        $('.donate-delete').click(function(){
            var thisDonateId = $(this).closest('ul').attr('class').substr(9);
            if(confirm("후원을 취소하시겠습니까?")){
                donateDeleteRequest(thisDonateId);
            }else{
                alert("후원 취소가 요청되었습니다");
            }
        });

    // 개인정보 끄기
        $('.x-button').click(function(){
            $('.mydata').addClass('invisible');
        })
    });

//회원삭제    
    $('.delete-button').click(function(){
        // var deleteIndex = $(this).closest('ul').index();
        var thisUserId = $(this).closest('ul').attr('class').substr(7);
        // alert(thisUserId);
        if(confirm("삭제하시겠습니까?")){
            userDeleteRequest(thisUserId);
        }else{
            alert("회원 삭제가 취소되었습니다");
        }
    });
});

// 회원 삭제 요청
function userDeleteRequest(id) {
    $.ajax({
        async: false,
        type: "delete",
        url: "/api/admin/user/" + id,
        dataType: "json",
        success: (response) => {
            alert("회원 삭제 완료!");
            location.reload();
        },
        error: (error) => {
            alert("회원 삭제 실패!");
            console.log(error);
        }
    });
}

// 후원 삭제 요청
function donateDeleteRequest(id) {
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