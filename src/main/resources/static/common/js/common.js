
function toastShow(type, msg){
    if(type == 99){
        $('.toast').append('<div class="toastItem SHOW">'+msg+'</div>');
    }else {
        $('.toast').append('<div class="toastItem SHOW">테스트입니다</div>');
    }
    
    setTimeout(function(){
        $('.toast .toastItem:first-child').removeClass('SHOW');
        setTimeout(function(){
            $('.toast .toastItem:first-child').remove();
        }, 1100);
    }, 3000);

}


function popupShow(depth, target){
    if(depth == '2'){
        $('.popupItem[data-popup="' + target+'"]').show();
        $('body').addClass('__'+target);
        $('body').addClass('layerDepth2');

    }else if(depth == '9'){
        $('.popupItem[data-popup="' + target+'"]').show();
        $('body').addClass('__'+target);
        $('body').addClass('layerDepthAhead');

    }else{
        if(target == 'layer-alert1' || target == 'layer-alert2'){
            $('.layer .dim').hide();
        }else {
            $('.layer .dim').show();
        }
        $('.popupItem[data-popup="' + target+'"]').show();
        $('.popup').show();
        $('body').addClass('__'+target);
    
        setTimeout(function(){
            $('body').addClass('layerON');
        }, 0);
    };



}

function popupHide(target){
     if($('body').hasClass('layerDepthAhead') || $('body').is('layerDepthAhead, layerDepth2')){
        $('body').removeClass('layerDepthAhead');

        $('body').removeClass('__'+target);
        $('.popupItem[data-popup="' + target+'"]').hide();

    }else if($('body').hasClass('layerDepth2')){
        $('body').removeClass('layerDepth2');

        $('body').removeClass('__'+target);
        $('.popupItem[data-popup="' + target+'"]').hide();

    }else{

        $('body').removeClass('layerON');

    
        setTimeout(function(){
        
            $('body').removeClass('__'+target);
            $('.popupItem[data-popup="' + target+'"]').hide();
            $('.popup').hide();
    
        }, 0);
    }

    if(target == 'layer-alert1'){
        $('.layer-alert1 .alertInfo').text('');

    }
}




function openMenu(){
	$('body').toggleClass('headerON');
}





function mapView(tileNo, selectCount){       // map locate Name write & checked Count sign script - sys 221016
    var areaArr = ['강북구','도봉구','노원구','은평구','종로구','성북구','동대문구','중랑구','마포구','서대문구','중구','성동구','광진구','용산구','강서구','양천구','영등포구','','동작구','서초구','강남구','송파구','강동구','구로구','금천구','관악구'];
    
    $('.mapTile[data-map='+tileNo+'] .status').html(
        '<h6>'+areaArr[Number(tileNo)-1]+'</h6><h4><span class="__style01">'+selectCount+'</span>곳</h4>'
    );
}


function conView(tileNo){       // map contents print script - sys 221016
    // if($('.mapTile[data-map='+tileNo+']').hasClass('ON')){
    //     $('.mapTile[data-map='+tileNo+']  > .wrap > .content').html('');
    // }else {
    //
    //     $('.mapTile[data-map='+tileNo+']  > .wrap > .content').html(
    //         '<div class="single">'+
    //         '<div class="wrap">'+
    //         '<div class="contentBox">'+
    //             '<div class="thm" style="background-image: url(https://www.mapo.go.kr/site/culture/file/image/uu/b6db29c93fe64cfab746a10cecb1c9bc);"></div>'+
    //             '<div class="infoBox">'+
    //                 '<div class="textBox">'+
    //                     '<h6><B>경의선 숲길</B></h6>'+
    //                     '<p>경의선과 공항철도가 지하화된 이후 오랫동안 방치되어 있던 경의선 옛 철길을 활용한 도심 속 휴식 공간이다. 가좌역 인근 연남동에서 용산구문화체육센터까지 이어지는 경의선숲길은 서울에</p>'+
    //                 '</div>'+
    //                 '<div class="dateBox">'+
    //                     '<span class="label">운영기간</span>'+
    //                     '<h5>2022.10.23 ~ 2022.11.01</h5>'+
    //                     // '<h6><span class="__style01">1일</span> 남음</h6>'+
    //                 '</div>'+
    //                 '<div class="graph"><div class="bar __style011" style="width: 40%"></div></div>'+
    //             '</div>'+
    //         '</div>'+
    //
    //         '<div class="btnBox">'+
    //             '<button type="button" class="btn _w35 _h35 __style021"><i class="icon"></i></button>'+
    //             '<button type="button" class="btn _h35 __style011">투어 추가</button>'+
    //         '</div>'+
    //         '</div>'+
    //         '</div>'
    //     );
    // }

    $('.mapTile[data-map='+tileNo+']').toggleClass('ON');

}


// function deckView(tileNo,conArr){       // map content hand Deck type print script - sys 221016
//     var count = conArr.length;
//     $('.mapTile[data-map='+tileNo+']  > .wrap > .content').attr('data-count',count);
//
//     var i;
//     for (i = 0; i < count; i++) {
//
//
//         $('.mapTile[data-map='+tileNo+'] > .wrap > .content').append(
//             // '<div class="deck">'+
//             '<div class="deck" data-con="'+conArr[i]+'">'+
//                 '<div class="wrap">'+
//                 '<div class="contentBox">'+
//                     '<div class="thm" style="background-image: url(https://www.mapo.go.kr/site/culture/file/image/uu/b6db29c93fe64cfab746a10cecb1c9bc);"></div>'+
//                         '<div class="textBox">'+
//                             '<h6><B>경의선 숲길</B></h6>'+
//                             '<p>경의선과 공항철도가 지하화된 이후 오랫동안 방치되어 있던 경의선 옛 철길을 활용한 도심 속 휴식 공간이다. 가좌역 인근 연남동에서 용산구문화체육센터까지 이어지는 경의선숲길은 서울에</p>'+
//                         '</div>'+
//                         '<div class="dateBox">'+
//                             '<span class="label">운영기간</span>'+
//                             '<h5>2022.10.23 ~ 2022.11.01</h5>'+
//                             '<h6><span class="__style01">1일</span> 남음</h6>'+
//                         '</div>'+
//                         '<div class="graph"><div class="bar __style011" style="width: 40%"></div></div>'+
//                         '<button type="button" class="detailBtn btn _w35 _h35 __style021"><i class="icon"></i></button>'+
//                         '<button type="button" class="stampBtn btn _w60 _h30 __style021">방문 완료</button>'+
//                 '</div>'+
//
//                 '</div>'+
//             '</div>'
//         );
//     }
// }

function conClear(){        // map content clear script - sys 221016
    $('.mapTile').removeClass('ON');
    $('.mapTile  > .wrap > .content').html('');
}




// function stampView(tileNo,conArr){      // map stamp & content print script - sys 221016
//
//     var count = conArr.length; // content count
//
//     $('.mapTile[data-map='+tileNo+']  > .wrap > .stampBox').addClass('GET');
//     $('.mapTile[data-map='+tileNo+']  > .wrap > .stampBox').attr('data-count',count);
//     var i;
//     for (i = 0; i < count; i++) {
//         $('.mapTile[data-map='+tileNo+'] > .wrap > .stampBox').append(
//             '<div class="stamp" data-con="'+conArr[i]+'">'+
//                 '<button type="button" class="btn"><i class="icon"></i></button>'+
//                 '<div class="content">'+
//                     '<div class="deck" data-con="1">'+
//                         '<div class="wrap">'+
//                             '<div class="contentBox">'+
//                                 '<div class="thm" style="background-image: url(https://www.mapo.go.kr/site/culture/file/image/uu/b6db29c93fe64cfab746a10cecb1c9bc);"></div>'+
//                                     '<div class="textBox">'+
//                                         '<h6><B>경의선 숲길</B></h6>'+
//                                         '<p>경의선과 공항철도가 지하화된 이후 오랫동안 방치되어 있던 경의선 옛 철길을 활용한 도심 속 휴식 공간이다. 가좌역 인근 연남동에서 용산구문화체육센터까지 이어지는 경의선숲길은 서울에</p>'+
//                                     '</div>'+
//                                     '<div class="dateBox">'+
//                                         '<span class="label">운영기간</span>'+
//                                         '<h5>2022.10.23 ~ 2022.11.01</h5>'+
//                                         '<h6><span class="__style01">1일</span> 남음</h6>'+
//                                     '</div>'+
//                                     '<div class="graph"><div class="bar __style011" style="width: 40%"></div></div>'+
//                                 '<button type="button" class="detailBtn btn _w35 _h35 __style021"><i class="icon"></i></button>'+
//                             '</div>'+
//                         '</div>'+
//                     '</div>'+
//                 '</div>'+
//             '</div>'
//         );
//     }
// }
function stampClear(){ // map stamp & content clear script - sys 221016
    $('.mapTile').removeClass('ON');
    $('.mapTile  > .wrap > .stampBox').removeClass('GET');
    $('.mapTile  > .wrap > .stampBox').html('');
}

function mapLoading(){

    $('.seoulArea .mapBox').append('<ul class="wrap"></ul>');
    
    var i;
    for (i = 0; i < 26; i++) {
        $('.seoulArea .mapBox > .wrap').append(
            '<li class="mapTile" data-map="'+Number(i+1)+'">'+
                '<div class="wrap">'+
                    '<div class="status"></div>'+
                    '<div class="content"></div>'+
                    '<div class="stampBox"></div>'+
                '</div>'+
            '</li>'
        );
    }

}


function doing(){       // All element interaction script  - sys 221016
    // content reload or reCall after use(append ...)
    
    $('.toggleBtn').on("click", function () { 
        $(this).closest('.toggleArea').toggleClass('ON');
    
    });
    

    $( ".btn, .deck, .stamp" )
    .mouseenter(function() {
        $( this ).addClass('HOVER');
    })
    .mouseleave(function() {
        $( this ).removeClass('HOVER');
    });

    $( ".mapTile" )
    .mouseenter(function() {
        $( this ).addClass('NOW');
    })
    .mouseleave(function() {
        $( this ).removeClass('NOW');
    });

     $('.btn').on("click", function () { 
        $(this).toggleClass('ON');
    
    });

    var nowLoca = $('body').attr("data-loca");
    if($('body').attr("data-loca") == nowLoca){
        $('header').find('.btn[data-cate="'+nowLoca+'"]').addClass('NOW')
    }



    
    $('.scToggle .btn').on("click", function () { 
        $(this).closest('.scToggle').attr('data-state',$(this).attr('data-btn'));
    });



    

    $( ".activeItem" )
    .mouseenter(function() {
        var mapNo = $(this).attr('data-map');
        conClear();
        $( '.activeItem' ).removeClass('HOVER');
        
        $( this ).addClass('HOVER');
        conView(mapNo);
    });


    $( ".stampItem" )
    .mouseenter(function() {
        var conNo = $(this).attr('data-con');
        $( this ).addClass('HOVER');
        $('.seoulArea .mapBox .mapTile  > .wrap > .content .deck[data-con="'+conNo+'"]').addClass('HOVER');
    })
    .mouseleave(function() {
        $( this ).removeClass('HOVER');
        $('.seoulArea .mapBox .mapTile  > .wrap > .content .deck').removeClass('HOVER');
    });

    $( ".seoulArea .mapBox .mapTile  > .wrap > .content .deck" )
    .mouseenter(function() {
        var conNo = $(this).attr('data-con');
        $( this ).addClass('HOVER');
        $('.stampItem[data-con="'+conNo+'"]').addClass('HOVER');
    })
    .mouseleave(function() {
        $( this ).removeClass('HOVER');
        $('.stampItem').removeClass('HOVER');
    });





    
    $('.stampBtn').on("click", function () { 
        var deck = $(this).closest('.deck');
        var conNo = deck.attr('data-con');
        if(deck.hasClass('STAMP')){
            $(this).text('방문 완료');
        }else{
            $(this).text('방문 취소');
        }
        $('[data-con="'+conNo+'"]').toggleClass('STAMP');
    });

}
window.addEventListener('touchstart', function() {
    // some logic
}, {passive:false}); // <-- mark the event listerner as NOT passive


$(document).ready(function() {

    //html include for UI Develop script - sys 220329
    window.addEventListener('load', function() {
        var allElements = document.getElementsByTagName('*');
        Array.prototype.forEach.call(allElements, function(el) {
            var includePath = el.dataset.includePath;
            if (includePath) {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200) {
                        el.outerHTML = this.responseText;
                    }
                };
                xhttp.open('GET', includePath, true);
                xhttp.send();
            }
        });
    });


    setTimeout(function() { // START :: html include script mapping need - sys 221016
        doing();


    }, 100); // END :: html include script mapping need - sys 221016
    

});






