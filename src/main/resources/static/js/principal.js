
function getPrincipal(){
    let responseData;

    $.ajax({
        async: false,
        type: "GET",
        url: "/api/account/principal/member",
        dataType: "json",
        success: (response) => {
            console.log(response);
            responseData = response.data;
        },
        error: (error) => {
            console.log(error);
        }
    });

    return responseData;
}

// user 목록 불러오기
function getUserList(){
    let userListData;

    $.ajax({
        async: false,
        type: "GET",
        url: "/api/admin/userlist",
        dataType: "json",
        success: (response) => {
            console.log(response);
            userListData = response.data;
        },
        error: (error) => {
            console.log(error);
        }
    });

    return userListData;
}

//user 개인 후원 목록 불러오기
function getmyList(id) {
    $.ajax({
        async: false,
        type: "GET",
        url: "/api/mypage/supportinfo/mylist/" + id,
        dataType: "json",
        success: (response) => {
            userMyData = response.data;
            console.log(userMyData);
        },
        error: (error) => {
            console.log(error);
        }
    });

    return userMyData;
}


