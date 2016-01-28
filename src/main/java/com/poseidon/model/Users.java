package com.poseidon.model;

import javax.persistence.*;

@Entity
public class Users {

	@Id
	@GeneratedValue
	private Long id;

	private String username;

	private String password;

	private boolean enabled;

	public static Users createUser(ContaView userView) {
		Users user = new Users();

		user.username = userView.getUsername();
		user.password = userView.getPassword();
		user.enabled = true;

		return user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}

	public Users comPassword(String password){
		setPassword(password);
		return this;
	}

	public Users comUsername(String username){
		setUsername(username);
		return this;
	}
}