
// // 클릭 이벤트 //
// $(function(){
//     $('.mypage-content-top li').click(function(){ // a 중 하나를 클릭했을때
//         $('.mypage-content-top a').removeClass('active'); // 아래 주석을 css 땠다 붙였다로 해결함~
//         $(this).find('a').addClass('active');

//         // $('.mypage-content a').css({ // 모든 a를 전부 아래 적용
//         //     borderBottom: 'none',
//         //     color: '#B7B8BA'
//         // });

//         // $(this).css({ // 내가 클릭한걸 아래로 바꾸겠다
//         //     borderBottom: '3px solid #1CABE2',
//         //     color: '#1CABE2'
//         // });

//         var index = $(this).index();
        
//         $('.mypage-content-bot > ul > li').addClass('invisible');
//         $('.mypage-content-bot > ul > li:eq('+index+')').removeClass('invisible');
//     });
//  });
 
 
// // 스크롤 이동에 따른 사이즈 변형 //
// $(window).scroll(function(){
//     $('.contact::after').css('left', 0-$(this).scrollLeft());

//   });
