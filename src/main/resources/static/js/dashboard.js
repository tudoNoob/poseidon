/**
 * Este arquivo destinasse para ser o principal arquivo que contém os scripts da tela dashboard.
 */

$(document).ready(function(){
	
	$('#btn-criarConta').click(function(){
		$('#containerDashboard').html($('#criarContaContainer'));
		$('#criarContaContainer').css('display','block');
	});
	
	$('#btn-exibirTodasContas').click(function(){
		$('#containerDashboard').html($('#exibrTodasContasContainer'));
		$('#exibrTodasContasContainer').css('display','block');
	});
	
	$('#btn-deletarConta').click(function(){
		$('#containerDashboard').html($('#deletarUsuarioContainer'));
		$('#deletarUsuarioContainer').css('display','block');
	});
	
	
});