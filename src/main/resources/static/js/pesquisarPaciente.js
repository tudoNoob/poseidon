/**
 * Este arquivo é destinado para todos os scripts relacionados a pagina
 * pesquisarPacientes.
 */

$(document)
		.ready(
				function() {
					$('#editarPaciente').on('click', function() {
						$('#dialog-newUser').dialog({
							height : 180,
							width : 400
						});
					});

					criandoPaginacao();
					function criandoPaginacao() {
						if ($('#pacientesJSON').val() === "") {
							return;
						}

						var pesquisaDados = JSON.parse($('#pacientesJSON')
								.val());
						var iterador =10;
						if(pesquisaDados.length<10){
							iterador=pesquisaDados.length;
						}
						paginacaoCriaRows(0,iterador,pesquisaDados);
						var maxlength= 5;
						if(pesquisaDados.length<5){
							maxlength=pesquisaDados.length;
						}
						$('#page-selection')
								.bootpag({
									total : 5,
									maxVisible: maxlength
								})
								.on(
										"page",
										function(event, num) {
											for(j=0;j<10;j++){
												$('#row'+j).remove();
											}	
											
											var iterador = num * 10;
											if(iterador>pesquisaDados.length){
												if(num===1){
													iterador=pesquisaDados.length;
												}else{
												return;
												}
											}
											var comeca = 0;
											if (num > 1) {
												comeca = iterador - 10;
											}
											paginacaoCriaRows(comeca,iterador,pesquisaDados);
											$(this).bootpag({
												total : pesquisaDados.length,
												maxVisible : 5
											});
										});

					}
					
					function paginacaoCriaRows(comeca,iterador,pesquisaDados){
						var id=0;
						for (i = comeca; i < iterador; i++) {
						
							
							var rowNumber = "row" + id
							var row = "<tr id=\""
									+ rowNumber
									+ "\"></td><td >"
									+ pesquisaDados[i].id
									+ "</td><td >"
									+ pesquisaDados[i].nome
									+ "</td><td >"
									+ pesquisaDados[i].cpf
									+ "</td><td >"
									+ pesquisaDados[i].email
									+ "</td><td >"
									+ pesquisaDados[i].telefone
									+ "</td><td >"
									+ pesquisaDados[i].celular
									+ "</td><td >"
									+ pesquisaDados[i].endereco
									+ "</td><td >"
									+ pesquisaDados[i].cep
									+ "</td><td >"
									+ pesquisaDados[i].data_de_nascimentoString
									+ "</td><td >"
									+ pesquisaDados[i].data_da_ultima_consultaString
									+ "</td></tr>";
							$("#firstRow").after(row);
							id=id+1;
						}
					}
					
				});