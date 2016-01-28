package com.poseidon.model;

public class ContaView {
	private String username;

	private String password;
	
	private String role;

	public ContaView() {
	}
	
	public static ContaView buildUserView(Users user){
		ContaView view = new ContaView();
		view.setPassword(user.getPassword());
		view.setUsername(user.getUsername());
		return view;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}	
	
	public ContaView comPassword(String password){
		setPassword(password);
		return this;
	}
	
	public ContaView comUsername(String username){
		setUsername(username);
		return this;
	}
	
	public ContaView comRoles(String role){
		setRole(role);
		return this;
	}
	
	@Override
	public String toString() {
		return "UserView [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
}
