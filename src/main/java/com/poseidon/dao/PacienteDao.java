package com.poseidon.dao;

import com.poseidon.model.Paciente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier()
public interface PacienteDao extends CrudRepository<Paciente, Long> {

	public Paciente findByNome(String nome);
	
}
