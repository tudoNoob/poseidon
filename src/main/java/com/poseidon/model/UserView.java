package com.poseidon.model;

public class UserView {
	private String username;

	private String password;
	
	private String role;

	public UserView() {
	}
	
	public static UserView buildUserView(Users user){
		UserView view = new UserView();
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

	@Override
	public String toString() {
		return "UserView [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	
}
