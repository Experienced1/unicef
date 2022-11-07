// 메인배너 슬라이딩 //
$(function(){
    setInterval(function(){        
        $('.slide-banner-txt').animate({
            marginLeft: -100 + "%"
        },500,function(){
            var web1 = $('.slide-banner-txt li:nth-child(1)').detach();
            $('.slide-banner-txt').append(web1);
            $('.slide-banner-txt').css("margin-left","0");
        });        

        $('.slide-banner').animate({
            marginLeft: -100 + "%"
        },500,function(){
            var web2 = $('.slide-banner li:nth-child(1)').detach();
            $('.slide-banner').append(web2);
            $('.slide-banner').css("margin-left","0");
        });        
    },5000);
    
});

// section4 후원하기 클릭 이벤트 //
$(function(){
    $('.section4-2>div>button').click(function(){
       $(this).css({
        background: 'rgb(255, 255, 255)',
        color: '#2589C9'
       }).siblings().css({
        background: '#2589C9',
        color: 'rgb(255, 255, 255)'
       });
       $('.section4-2>div>input').css({
        background: 'rgb(255, 255, 255)',
        color: 'rgb(150, 150, 150)'
       })
       var index = $(this).index();
       $('.section4-2 ul li:eq('+index+')').removeClass('invisible').siblings().addClass('invisible');
    });
 });
 
 