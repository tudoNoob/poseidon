package com.poseidon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quiropraxista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;

	public Quiropraxista() {

	}

	public Quiropraxista(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Quiropraxista [id=" + id + ", nome=" + nome + "]";
	}
}
