// my-info //// my-info //
// 아이디 재인증 > 개인정보 수정 이동 버튼 //
$(function(){    
    $('.my-info .eidt-go-btn').click(function(){
        $('.my-info').addClass('invisible');
        $('.my-info-edit').removeClass('invisible');
    });
 });


// my-info-edit //// my-info-edit //
// 비밀번호 변경 //
$(function(){
    $('.my-info-edit .article2 .password-edit-btn').click(function(){
        if($(this).html() == '비밀번호 변경'){
            $(this).html('비밀번호 변경 취소')
        }else{
            $(this).html('비밀번호 변경')
        }
        $('.my-info-edit .article2 .password-edit').toggle();
    });
 });
 

// 팝업 이벤트 //
$(function(){
    $('.my-info-edit .eidt-done-btn').click(function(){
        $('.edit-popup').removeClass('invisible');
    });

    $('.edit-done').click(function(){
        $('.edit-popup').addClass('invisible');
    });
 });

 
 