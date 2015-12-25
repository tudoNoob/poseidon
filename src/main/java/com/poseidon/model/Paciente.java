package com.poseidon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.joda.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuppressWarnings("unused")
public class Paciente {

	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private LocalTime data_nasc;
	private String email;
	private String telefone;
	private String cpf;
}
