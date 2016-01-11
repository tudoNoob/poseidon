package com.poseidon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poseidon.annotation.NotNullArgs;
import com.poseidon.dao.*;
import com.poseidon.model.*;

@Controller
public class UsuarioController {

	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	@Autowired
	private UserRepository  userRepository;
	
	@Autowired
	private DadoSessao dadoSessao;
	
	@RequestMapping(value="/createUser")
	@NotNullArgs
	public ModelAndView createUser(@ModelAttribute UserView userView,@ModelAttribute String role, ModelAndView modelAndView){
		Users user = Users.createUser(userView);
		if(dadoSessao.getIdUsuario()!= null)user.setId(dadoSessao.getIdUsuario());
		System.out.println("CREATE USER");
		System.out.println("user>"+user.toString());
		userRepository.save(user);
		modelAndView.setViewName("redirect:/dashboard");
		if(role!= null && !role.isEmpty()){
			
			userView.setRole(role);
			modelAndView.setViewName("redirect:/home");
		}
		if(dadoSessao.getIdUsuario()== null)authoritiesRepository.save(new Authorities(user.getUsername(),new StringBuilder().append("ROLE_").append(userView.getRole()).toString()));
		dadoSessao.setIdUsuario(null);
		return modelAndView;
	}
	
	@RequestMapping(value="/createSimpleUser")
	@NotNullArgs
	public ModelAndView createSimpleUser(@ModelAttribute UserView userView, ModelAndView modelAndView, RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute(userView);
		redirectAttributes.addFlashAttribute("USER");
		modelAndView.setViewName("redirect:/createUser");
		return modelAndView;
	}
	
	@RequestMapping(value="/deleteUser")
	@NotNullArgs
	public ModelAndView deleteUser(@ModelAttribute UserView userView, ModelAndView modelAndView){
		Users user = userRepository.findByUsername(userView.getUsername());
		Authorities authorities = authoritiesRepository.findByUsername(userView.getUsername());
		System.out.println("Delete USER");
		System.out.println("user>"+user.toString());
		userRepository.delete(user);
		authoritiesRepository.delete(authorities);
		modelAndView.setViewName("redirect:/dashboard");
		return modelAndView;
	}
	


	
	@RequestMapping("/editarUser")
	@NotNullArgs
	public ModelAndView editarUsuario(ModelAndView modelAndView, @ModelAttribute UserView userView, RedirectAttributes redirectAttributes){
		Users user = userRepository.findByUsername(userView.getUsername());
		if(user == null){
			redirectAttributes.addFlashAttribute("userView",userView);
			redirectAttributes.addFlashAttribute("isEditarError", "true");
			modelAndView.setViewName("redirect:/dashboard");
			return modelAndView;
		}
		dadoSessao.setIdUsuario(user.getId());
		Authorities authorities = authoritiesRepository.findByUsername(userView.getUsername());
		userView.setPassword(user.getPassword());
		userView.setUsername(user.getUsername());
		userView.setRole(authorities.getAuthority().replace("ROLE_", ""));
		redirectAttributes.addFlashAttribute("isEditar", "isEditar");
		redirectAttributes.addFlashAttribute("userView",userView);
		modelAndView.setViewName("redirect:/dashboard");
		return modelAndView;
	}

	
}
