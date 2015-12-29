/**
 * Este arquivo é só para scprits relacionados ao header das páginas.
 */

$(document).ready(function(){
	
	
$( ".menu" ).each(function( index ) {
			$(this).removeClass('active');
			var link=$(this).children();
			  var url= $(link).attr('url');
			  var pathname=window.location.pathname;
			  if(url==pathname){
				  $(this).addClass('active');
				  link.removeClass('colorBranco');
				  link.addClass("focusedMenu");
			  }
			});
		
		$( ".menu a" ).hover(function() {
			  $(this).addClass("focusedMenu");
			},function(){
				$(this).removeClass("focusedMenu");
			});
		
		
});