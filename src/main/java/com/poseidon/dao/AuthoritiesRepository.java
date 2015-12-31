package com.poseidon.dao;

import org.springframework.data.repository.CrudRepository;

import com.poseidon.model.Authorities;

public interface AuthoritiesRepository extends CrudRepository<Authorities, Long>{
	
	  public Authorities findByUsername(String username);
	  
}