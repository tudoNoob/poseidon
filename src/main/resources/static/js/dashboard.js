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
		sumirEditarConta();
	});
	
	$('#btn-exibirTodasContas').click(function(){
		$('#containerDashboard').html(exibirContaContainer);
		$('#exibrTodasContasContainer').css('display','block');
		sumirEditarConta();
	});
	
	$('#btn-deletarConta').click(function(){
		$('#containerDashboard').html(deletarUsuarioContainer);
		$('#deletarUsuarioContainer').css('display','block');
		sumirEditarConta();
	});
	
	$('#btn-editarConta').click(function(){
		$('#containerDashboard').html(editarUsuarioContainer);
		$('#editarUsuarioContainer').css('display','block');
	});
	
	 $('[data-toggle="tooltip"]').tooltip();  // para criar as tooltips.
	 
	 function sumirEditarConta(){
		 $('#editarContaContainer').css('display','none');
	 }
	 editarUsuarioErro($('#editarErro').val());
	 function editarUsuarioErro(erro){
		 if(erro=='true'){
			 $('#editarAlertErro').css('display','block');
			 $('#btn-editarConta').trigger('click');
		 }else{
			 
		 }
	}
	
});

