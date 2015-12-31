package com.poseidon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poseidon.dao.AuthoritiesRepository;
import com.poseidon.dao.UserRepository;
import com.poseidon.model.Authorities;
import com.poseidon.model.UserView;
import com.poseidon.model.Users;

@Controller
public class UsuarioController {

	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	@Autowired
	private UserRepository  userRepository;
	
	@RequestMapping(value="/createUser")
	public String createUser(@ModelAttribute UserView userView){
		Users user = Users.createUser(userView);
		System.out.println("CREATE USER");
		System.out.println("user>"+user.toString());
		userRepository.save(user);
		authoritiesRepository.save(new Authorities(user.getUsername(),new StringBuilder().append("ROLE_").append(userView.getRole()).toString()));
		return "/home";
	}
	
}
