/**
 * Este arquivo é só para scprits relacionados ao header das páginas.
 */
$(function () {
    $(".menu").find('li').each(function (index) {
        $(this).find('a').removeClass('colorBrancoActive');
        var url = $(this).attr('name');
        var pathname = window.location.pathname;
        if (url === pathname) {
            $(this).find('a').addClass('colorBrancoActive');
        }
    });
});