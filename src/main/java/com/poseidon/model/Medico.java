package com.poseidon.model;

import javax.persistence.*;

@Entity
public class Medico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	
	public Medico(){
		
	}
	
	public Medico(Integer id, String nome){
		this.id = id;
		this.nome = nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}

	@Override
	public String toString() {
		return "Medico [id=" + id + ", nome=" + nome + "]";
	}
	
	
}
