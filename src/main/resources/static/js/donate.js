// first-step //// first-step //
// 정기+일시 구분 btn //
$(function(){
    $('.first-step .pledge-btn').click(function(){
        //정기후원 클릭시
        $(this).addClass('active').siblings().removeClass('active');
        $('.first-step .donate1-3-pledge').removeClass('invisible');
        $('.first-step .donate1-3-oneoff').addClass('invisible');

        $('.donate1-4 > span > strong').html('30,000');
    });
    
    $('.first-step .oneoff-btn').click(function(){
        //일시후원 클릭시
        $(this).addClass('active').siblings().removeClass('active');
        $('.first-step .donate1-3-oneoff').removeClass('invisible');
        $('.first-step .donate1-3-pledge').addClass('invisible');

        $('.donate1-4 > span > strong').html('50,000');    });
 });


// 후원금액 btn //
$(function(){
    $('.first-step .donate1-3-pledge input').click(function(){
        //정기_후원금액(원) 클릭시
        $(this).addClass('active').siblings().removeClass('active');
        $('.text-button').removeClass('active');

        var pledgePick = $('.donate1-3-pledge strong:nth-child(1)').html($(this).val());
        if(pledgePick == '30,000'){
            $('.donate1-3-pledge strong:nth-child(2)').html('홍역 예방백신 720회분');
        }else if($(pledgePick) == '50,000'){
            $('.donate1-3-pledge strong:nth-child(2)').html('소아마비 예방백신 6,000회분');
        }else if($(pledgePick) == '100,000'){
            $('.donate1-3-pledge strong:nth-child(2)').html('태양광램프 34개');
        }else if($(pledgePick) == '200,000'){
            $('.donate1-3-pledge strong:nth-child(2)').html('공책 4,800권');
        }else if($(pledgePick) == '300,000'){
            $('.donate1-3-pledge strong:nth-child(2)').html('소아마비 예방백신 18,000회분');
        }else{
            $('.donate1-3-pledge strong:nth-child(1)').html($(this).val()+'원');
            $('.donate1-3-pledge strong:nth-child(2)').html('소아마비 예방백신 18,000회분');
        }
        
        //총액
        $('.donate1-4 .total-donate').html($(this).val());
    });
    
    $('.first-step .donate1-3-oneoff input').click(function(){
        //일시_후원금액(원) 클릭시
        $(this).addClass('active').siblings().removeClass('active');
        $('.text-button').removeClass('active');

        //총액
        $('.donate1-4 .total-donate').html($(this).val());
    });
 });
 
 