package com.poseidon.dao;

import com.poseidon.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<Users, Long> {
	
    public Users findByUsername(String username);
    
}