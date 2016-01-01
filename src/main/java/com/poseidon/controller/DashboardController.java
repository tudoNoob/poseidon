package com.poseidon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.model.UserView;

@Controller
public class DashboardController {
	
	@Autowired
	private UsuarioController usuarioController;
	
	 @RequestMapping("/dashboard")
	    public ModelAndView home(ModelAndView  modelAndView,@ModelAttribute UserView userView, @ModelAttribute String isEditar){
	        modelAndView.setViewName("dashboard");
	        modelAndView.getModelMap().addAttribute("userView", userView);
	       if(isEditar!= null && !isEditar.isEmpty()) modelAndView.getModelMap().addAttribute("isEditar", isEditar);
	        usuarioController.achaTodosUsuarios(modelAndView);
	        return modelAndView;
	    }
	 
}
