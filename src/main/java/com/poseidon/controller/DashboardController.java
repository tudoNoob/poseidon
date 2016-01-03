package com.poseidon.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.poseidon.advices.NotNullArgs;
import com.poseidon.dao.*;
import com.poseidon.model.*;

@Controller
public class DashboardController {

	@Autowired
	private MedicoDao medicoRepository;
	
	@Autowired
	private UserRepository  userRepository;
	
	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	@RequestMapping("/dashboard")
	@NotNullArgs
	public ModelAndView buildDashboardPage(ModelAndView modelAndView, @ModelAttribute UserView userView,
			@ModelAttribute("isEditar") String isEditar, @ModelAttribute("isEditarError") String isEditarError) {
		modelAndView.setViewName("dashboard");
		modelAndView.getModelMap().addAttribute("userView", userView);
		if (isEditar != null && !isEditar.isEmpty()){
			modelAndView.getModelMap().addAttribute("isEditarString", isEditar);
		}
		if (isEditarError != null && !isEditarError.isEmpty()) {
			modelAndView.getModelMap().addAttribute("formEditarError", isEditarError);
		}else{
			modelAndView.getModelMap().addAttribute("formEditarError", false);
		}
		achaTodosMedicos(modelAndView);
		achaTodosUsuarios(modelAndView);
		
		return modelAndView;
	}

	private void achaTodosUsuarios(ModelAndView modelAndView) {
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
	
	private void achaTodosMedicos(ModelAndView modelAndView) {
		Iterable<Medico> medicoList = medicoRepository.findAll();
		List<Medico> medicoView= Lists.newArrayList();
		for(Medico medico : medicoList){
			medicoView.add(medico);
		}
		
		modelAndView.getModelMap().addAttribute("medicos", medicoView);
	}
	
}
