package com.poseidon.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poseidon.model.Medico;

@Repository
@Qualifier()
public interface MedicoDao extends CrudRepository<Medico, Long>{
	public Medico findByNome(String nome);
}
