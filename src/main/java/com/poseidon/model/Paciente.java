package com.poseidon.model;

import java.util.Date;

import javax.persistence.*;

import com.google.common.base.Objects;
import com.poseidon.utils.PoseidonUtils;

@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String sobrenome;
	private String email;
	private String telefone;
	private String celular;
	private String endereco;
	private String cep;
	private Date data_de_nascimento;
	@Transient
	private String data_de_nascimentoString;
	private Date data_da_ultima_consulta;
	@Transient
	private String data_da_ultima_consultaString;
	private String forma_de_pagamento;
	private String cpf;

	public Paciente() {
		this.nome="";
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}



	public Date getDataNasci_For_SQL() {
		return PoseidonUtils.convertToDate(data_de_nascimento);
	}

	

	public Date getData_da_ultima_consulta() {
		return data_da_ultima_consulta;
	}



	public void setData_da_ultima_consulta(Date data_da_ultima_consulta) {
		this.data_da_ultima_consulta = data_da_ultima_consulta;
	}



	public void setData_de_nascimento(Date data_de_nascimento) {
		this.data_de_nascimento = data_de_nascimento;
	}



	public Date getData_de_nascimento() {
		return data_de_nascimento;
	}



	public Date getDataConsulta_For_SQL() {
		return PoseidonUtils.convertToDate(data_da_ultima_consulta);
	}

	public String getForma_de_pagamento() {
		return forma_de_pagamento;
	}

	public void setForma_de_pagamento(String forma_de_pagamento) {
		this.forma_de_pagamento = forma_de_pagamento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public String getData_de_nascimentoString() {
		return PoseidonUtils.convertDateToString(data_de_nascimento);
	}



	public void setData_de_nascimentoString(String data_de_nascimentoString) {
		this.data_de_nascimentoString = data_de_nascimentoString;
	}

	


	public String getData_da_ultima_consultaString() {
		return PoseidonUtils.convertDateToString(data_da_ultima_consulta);
	}



	public void setData_da_ultima_consultaString(String data_da_ultima_consultaString) {
		this.data_da_ultima_consultaString = data_da_ultima_consultaString;
	}



	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("nome", nome).add("sobrenome", sobrenome).add("email", email)
				.add("telefone", telefone).add("celular", celular).add("endereco", endereco).add("cep", cep)
				.add("data_de_nascimento", data_de_nascimento).add("data_da_ultima_consulta", data_da_ultima_consulta)
				.add("forma_de_pagamento", forma_de_pagamento).toString();
	}

}