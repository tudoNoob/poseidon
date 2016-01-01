package com.poseidon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
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
	public ModelAndView createUser(@ModelAttribute UserView userView,@ModelAttribute String role, ModelAndView modelAndView){
		Users user = Users.createUser(userView);
		System.out.println("CREATE USER");
		System.out.println("user>"+user.toString());
		userRepository.save(user);
		modelAndView.setViewName("redirect:/dashboard");
		if(role!= null && !role.isEmpty()){
			
			userView.setRole(role);
			modelAndView.setViewName("redirect:/home");
		}
		authoritiesRepository.save(new Authorities(user.getUsername(),new StringBuilder().append("ROLE_").append(userView.getRole()).toString()));
		
		return modelAndView;
	}
	
	@RequestMapping(value="/createSimpleUser")
	public ModelAndView createSimpleUser(@ModelAttribute UserView userView, ModelAndView modelAndView, RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute(userView);
		redirectAttributes.addFlashAttribute("USER");
		modelAndView.setViewName("redirect:/createUser");
		return modelAndView;
	}
	
	@RequestMapping(value="/deleteUser")
	public ModelAndView deleteUser(@ModelAttribute UserView userView, ModelAndView modelAndView){
		Users user = Users.createUser(userView);
		System.out.println("CREATE USER");
		System.out.println("user>"+user.toString());
		userRepository.delete(user);
		authoritiesRepository.delete(new Authorities(user.getUsername(),new StringBuilder().append("ROLE_").append(userView.getRole()).toString()));
		modelAndView.setViewName("redirect:/dashboard");
		return modelAndView;
	}
	

	public void achaTodosUsuarios(ModelAndView modelAndView) {
		Iterable<Users> usersList = userRepository.findAll();
		List<UserView> userViews= Lists.newArrayList();
		for(Users users : usersList){
			Authorities authorities = authoritiesRepository.findByUsername(users.getUsername());
			UserView userView = UserView.buildUserView(users);
			userView.setRole(authorities.getAuthority());
			userViews.add(userView);
		}
		
		modelAndView.getModelMap().addAttribute("usuarios", userViews);
	}
	
}
