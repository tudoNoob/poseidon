package com.poseidon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.joda.time.LocalDate;

@Entity
public class Paciente {

	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private LocalDate data_nasc;
	private String email;
	private String telefone;
	private String cpf;

    public Paciente() {
    }

    public Paciente(Integer id, String nome, LocalDate data_nasc, String email, String telefone, String cpf) {
        this.id = id;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(LocalDate data_nasc) {
		this.data_nasc = data_nasc;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


}
