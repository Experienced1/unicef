let userId = null;
let count_donate = 1;
let totalAmount = 0;

$(function(){
    let userList = getUserList();

    console.log(JSON.stringify(userList));

    const userdataTotal = document.querySelector(".userdata-total");
    const userdataList = document.querySelector(".userdata-list");

    //회원목록
    userdataTotal.innerHTML = `
        <p>
            전체 후원자 <span>${userList.length}</span>명
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
    for(i=0; i < userList.length; i++){

        if(userList[i].userId == userList[i+1].userId){
            count_donate += 1;
            totalAmount += userList[i].donateAmount;

            continue;
        }else{
            mainUsername = userList[i].mainUsername;
            oauthUsername = userList[i].oauthUsername;
            userProvider = userList[i].userProvider;
            userBirthdate = userList[i].userBirthdate;
            userEmail = userList[i].userEmail;
            userName = userList[i].userName;
            userPhone = userList[i].userPhone.replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-");
            createDate = userList[i].createDate.substr(0, 10);  
            totalAmount = userList[i].donateAmount;
        }


        userdataList.innerHTML += `
            <ul class="userId-${userId}">
                <li>${mainUsername}</li>
                <li>${userName}</li>
                <li>${userPhone}</li>
                <li>${userEmail}</li>
                <li>${createDate}</li>
                <li>
                    <span>0</span>
                    <span> / </span>
                    <span>${count_donate}</span>
                </li>
                <li>${totalAmount}</li>
                <li>
                    <i class="fa-regular fa-pen-to-square"></i>
                </li>
                <li class = "delete-button">
                    <i class="fa-solid fa-minus"></i>
                </li>
            </ul>
        `;

        count_donate = 1;
    }

    
    $('.delete-button').click(function(){
        // var deleteIndex = $(this).closest('ul').index();
        var thisUserId = $(this).closest('ul').attr('class').substr(7);
        alert(thisUserId);

        if(confirm("삭제하시겠습니까?")){
            deleteRequest(thisUserId);
        }else{
            alert("회원 삭제가 취소되었습니다");
        }
    });
});

// 회원 삭제 요청
function deleteRequest(id) {
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