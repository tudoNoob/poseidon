package com.poseidon.dao;

import com.poseidon.model.Quiropraxista;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier()
public interface MedicoDao extends CrudRepository<Quiropraxista, Integer>{
	public Quiropraxista findByNome(String nome);
	public Quiropraxista findById(Integer id);
}
