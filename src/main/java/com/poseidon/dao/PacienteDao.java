package com.poseidon.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poseidon.model.Paciente;

@Repository
@Qualifier()
public interface PacienteDao extends CrudRepository<Paciente, Integer> {

	public Paciente findByNome(String nome);
	
}
