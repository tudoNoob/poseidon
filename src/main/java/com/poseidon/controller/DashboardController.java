package com.poseidon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.model.*;

@Controller
public class DashboardController {

	@Autowired
	private UsuarioController usuarioController;
	
	//Teste
	@Autowired
	private MedicoController medicoController;

	@RequestMapping("/dashboard")
	public ModelAndView home(ModelAndView modelAndView, @ModelAttribute UserView userView,
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
		medicoController.achaTodosMedicos(modelAndView);
		usuarioController.achaTodosUsuarios(modelAndView);
		
		return modelAndView;
	}

}
