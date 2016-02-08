package com.poseidon.dao;

import com.poseidon.model.Authorities;
import org.springframework.data.repository.CrudRepository;

public interface AuthoritiesRepository extends CrudRepository<Authorities, Long>{
	
	  public Authorities findByUsername(String username);
	  
}