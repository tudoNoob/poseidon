/**
 * Este arquivo destinasse para ser o principal arquivo que contém os scripts da tela dashboard.
 */

$(document).ready(function(){
	
	$('#btn-criarConta').click(function(){
		$('#containerDashboard').html($('#criarContaContainer'));
		$('#criarContaContainer').css('display','block');
	});
	
	
});