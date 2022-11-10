const totalDonate = $('.donate1-4 .total-donate'); // 총액

// 스텝 단계 이동 btn //
$(function(){
    $('.next-button').click(function(){
    //다음버튼 클릭시 //
        var liIndex = $(this).closest('li').index();

        if(liIndex < 3){
            $('.donate-content-auto > li:eq('+liIndex+')').addClass('invisible');
            
            $('html').scrollTop(0);
            $('.donate-content-auto > li:eq('+(liIndex + 1)+')').removeClass('invisible');
        }

    // 선택정보 명시 //
        // 후원방법
        var sponsorship = $("select[name=sponsorship]").val();
        var buttonpick = $(".first-step .donate1-1 button.active").html();
        $('.step1-summary').html(sponsorship + '/' + totalDonate.html() + '/' + buttonpick + '후원');

        // 후원자정보
        var username = $('.donate2-1 > div:nth-child(2) > input').val();
        var userbirth = $('.donate2-1 > div:nth-child(4) > input').val();
        $('.step2-summary').html(username + '/' + userbirth);

    });

    $('.prev-button').click(function(){
        //변경버튼 클릭시
        var liIndex = $(this).closest('li').index();
        var prevIndex = $(this).closest('div.inactive-step').index();

        $('.donate-content-auto > li:eq('+liIndex+')').addClass('invisible');
        $('html').scrollTop(0);
        $('.donate-content-auto > li:eq('+(prevIndex - 1)+')').removeClass('invisible');
    });
 });

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
    //정기_후원금액(원) 클릭시
    $('.donate1-3-pledge .text-button').keyup(function(){
        totalDonate.html($('.donate1-3-pledge .text-button').val());
    })

    $('.first-step .donate1-3-pledge input').click(function(){
        $(this).addClass('active').siblings().removeClass('active');
        $('.text-button').removeClass('active');

        var pledgePick = $('.donate1-3-pledge strong:nth-child(1)').html($(this).val());

        if($(this).val() == '30,000'){
            $('.donate1-3-pledge strong:nth-child(2)').html('홍역 예방백신 720회분');
        }else if($(this).val() == '50,000'){
            $('.donate1-3-pledge strong:nth-child(2)').html('소아마비 예방백신 6,000회분');
        }else if($(this).val() == '100,000'){
            $('.donate1-3-pledge strong:nth-child(2)').html('태양광램프 34개');
        }else if($(this).val() == '200,000'){
            $('.donate1-3-pledge strong:nth-child(2)').html('공책 4,800권');
        }else if($(this).val() == '300,000'){
            $('.donate1-3-pledge strong:nth-child(2)').html('소아마비 예방백신 18,000회분');
        }else{
            $('.donate1-3-pledge strong:nth-child(1)').html($(this).val()+'원');
            $('.donate1-3-pledge strong:nth-child(2)').html('소아마비 예방백신 18,000회분');
        }
        
        //총액
        totalDonate.html($(this).val());
    });

    //일시_후원금액(원) 클릭시    
    $('.donate1-3-oneoff .text-button').keyup(function(){
        totalDonate.html($('.donate1-3-oneoff .text-button').val());
    })
    
    $('.first-step .donate1-3-oneoff input').click(function(){
        $(this).addClass('active').siblings().removeClass('active');
        $('.text-button').removeClass('active');

        //총액
        totalDonate.html($(this).val());
    });
 });
 
 
// second-step //// second-step //
// 기부금 영수증 chk-box btn //
$(function(){
    $('#chk_box').click(function(){
        if($('.donate2-1-receipt > div').hasClass('invisible')){
            $('.donate2-1-receipt > div').removeClass('invisible');
        }else{
            $('.donate2-1-receipt > div').addClass('invisible');
        }

    })
 });
