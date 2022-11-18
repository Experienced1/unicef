const FileAddButton = document.querySelector(".add-button");
const fileInput = document.querySelector(".file-input")
const submitGoButton = document.querySelector(".submit-button");


let noticeImgFiles = new Array();

FileAddButton.onclick = () => {
    fileInput.click();
}

fileInput.onchange = () => {
    const formData =  new FormData(document.querySelector("form"));

    formData.forEach((value) => {
        if(value.size !=0){
            noticeImgFiles.push(value);
            console.log(noticeImgFiles);

           
        }
       
    });
    getImgPreview();
    fileInput.value = null;
}

// 이미지 미리보기
function getImgPreview(){
    const noticeImages = document.querySelector(".notice-images");

    noticeImages.innerHTML = "";

   
   noticeImgFiles.forEach((file, i) => {
       

        const reader = new FileReader();

        reader.onload = (e) => {
            noticeImages.innerHTML += `
            <div class="img-box">
                <i class="fa-solid fa-xmark"></i>
                <img class="notice-img" src="${e.target.result}" alt="">
            </div>     
            `;

            const deleteButton = document.querySelectorAll(".fa-xmark");
            deleteButton.forEach((xbutton, index) => {
                xbutton.onclick = () => {
                    if(confirm("상품 이미지를 지우시겠습니까?")) {
                        noticeImgFiles.splice(index, 1);
                        console.log(noticeImgFiles);
                        getImgPreview();
                    }
                };
            })

        }

        // readAsDataURL 호출하면 onload 호출됨

        // 파일의 경로(URL)가 result 에 담긴다
        // reader에는 파일1개가 들어가는데 파일을 반복돌릴때 reader객체가 하나씩 생성해서 넣어줌
     
        // 비동기처리
        setTimeout(reader.readAsDataURL(file), i * 100);
    });
}



submitGoButton.onclick = () => {
    const noticeInputs = document.querySelectorAll(".notice-input");

    let formData = new FormData();

    formData.append("title", noticeInputs[0].value);
    formData.append("content", noticeInputs[1].value);

    noticeImgFiles.forEach((file) => {
        formData.append("files", file);

    });
    formData.forEach((value, key) => {
        console.log(key);
        console.log(value);
        console.log();
        
    })
    request(formData);
}

function request(formData){

    $.ajax({
        async: false,
        type: "post",
        url: "/api/admin/notice",
        enctype: "multipart/form-data",
        contentType: "application/json",
        contentType: false,
        processData: false,
        data: formData,
        dataType: "json",
        success: (response) => {
            alert("공지사항 게시글 등록 완료");
            // location.replace("/admin/save");
        },
        error: (error) => {
            alert("공지사항 게시글 등록 실패");
            console.log(error);
        }
    });

}
    