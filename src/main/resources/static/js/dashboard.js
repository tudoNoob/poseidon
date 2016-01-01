/**
 * Este arquivo destinasse para ser o principal arquivo que contém os scripts da tela dashboard.
 */

$(document).ready(function(){
	
	var criarContaContainer=$('#criarContaContainer');
	var exibirContaContainer=$('#exibrTodasContasContainer');
	var deletarUsuarioContainer=$('#deletarUsuarioContainer');
	var editarUsuarioContainer=$('#editarUsuarioContainer');

	$('#btn-criarConta').click(function(){
		$('#containerDashboard').html(criarContaContainer);
		$('#criarContaContainer').css('display','block');
	});
	
	$('#btn-exibirTodasContas').click(function(){
		$('#containerDashboard').html(exibirContaContainer);
		$('#exibrTodasContasContainer').css('display','block');
	});
	
	$('#btn-deletarConta').click(function(){
		$('#containerDashboard').html(deletarUsuarioContainer);
		$('#deletarUsuarioContainer').css('display','block');
	});
	
	$('#btn-editarConta').click(function(){
		$('#containerDashboard').html(editarUsuarioContainer);
		$('#editarUsuarioContainer').css('display','block');
	});
	
});