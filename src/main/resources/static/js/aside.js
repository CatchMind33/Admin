    $(".nav-li").click(function(){
    if($(this).hasClass("active")){ // 클릭한 요소가 clicked이라는 클래스명을 가지고 있을 때
    $(this).removeClass("active");
}else{
    $(this).addClass("active");
}
});
    // $("main-nav__link").click(function(){
    //     $(this).toggleClass("main-nav--active");
    // });