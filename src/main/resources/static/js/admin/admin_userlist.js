console.log(getUserList()[0].userId);
console.log(getUserList()[0].mainUsername);
console.log(getUserList()[0].oauthUsername);
console.log(getUserList()[0].userProvider);
console.log(getUserList()[0].userBirthdate);
console.log(getUserList()[0].userEmail);
console.log(getUserList()[0].userName);
console.log(getUserList()[0].userPhone);
console.log(getUserList()[0].createDate);


$(function(){
    const userdataList = document.querySelector(".userdata-list");

    for(i=0; i<getUserList().length; i++){
        userId = getUserList()[i].userId;
        mainUsername = getUserList()[i].mainUsername;
        oauthUsername = getUserList()[i].oauthUsername;
        userProvider = getUserList()[i].userProvider;
        userBirthdate = getUserList()[i].userBirthdate;
        userEmail = getUserList()[i].userEmail;
        userName = getUserList()[i].userName;
        userPhone = getUserList()[i].userPhone.replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-");
        createDate = getUserList()[i].createDate.substr(0, 10);
            

        userdataList.innerHTML += `
            <ul>
                <li>${mainUsername}</li>
                <li>${userName}</li>
                <li>${userPhone}</li>
                <li>${userEmail}</li>
                <li>${createDate}</li>
                <li>
                    <span>0</span>
                    <span> / </span>
                    <span>1</span>
                </li>
                <li>1,000</li>
                <li>
                    <i class="fa-regular fa-pen-to-square"></i>
                </li>
                <li>
                    <i class="fa-solid fa-minus"></i>
                </li>
            </ul>
        `;
    }
});