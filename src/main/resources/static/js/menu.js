/**
 * Este arquivo é só para scprits relacionados ao header das páginas.
 */
$(function () {
    $(".colorBranco").click(function(){
        $(this).addClass('colorBrancoClicked');
    });
    $(".menu").each(function (index) {
        $(this).find('li').find('a').removeClass('active');
        var url = $(this).find('li').attr('name');
        var pathname = window.location.pathname;
        console.log(link);
        console.log(url);
        console.log(pathname);
        console.log($(this).find('li'));
        if (url === pathname) {
            $(this).find('li').find('a').addClass('colorBrancoActive');
        }
    });
    console.log($(".menu"));
});