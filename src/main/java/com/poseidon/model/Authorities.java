package com.poseidon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Authorities {

	@Id
    @GeneratedValue
    private Long id;
	
	private  String username;
	
	private String authority;

	public String getUsername() {
		return username;
	}

	public Authorities() {
	}

	public Authorities(String username, String authority) {
		this.setAuthority(authority);
		this.setUsername(username);
	}

	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
