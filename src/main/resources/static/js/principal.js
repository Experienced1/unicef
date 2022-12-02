
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


function getUserList(){
    let userListData;

    $.ajax({
        async: false,
        type: "GET",
        url: "/api/admin/userlist",
        dataType: "json",
        success: (response) => {
            userListData = response.data;
        },
        error: (error) => {
            console.log(error);
        }
    });

    return userListData;
}




