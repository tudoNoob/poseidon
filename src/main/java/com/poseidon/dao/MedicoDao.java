package com.poseidon.dao;

import com.poseidon.model.Medico;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier()
public interface MedicoDao extends CrudRepository<Medico, Integer>{
	public Medico findByNome(String nome);
	public Medico findById(Integer id);
}
