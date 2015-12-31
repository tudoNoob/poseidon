package com.poseidon.dao;

import org.springframework.data.repository.CrudRepository;

import com.poseidon.model.Users;

public interface UserRepository  extends CrudRepository<Users, Long> {
	
    public Users findByUsername(String username);
    
}