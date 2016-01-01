package com.poseidon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {
	
	@Autowired
	private UsuarioController usuarioController;
	
	 @RequestMapping("/dashboard")
	    public ModelAndView home(ModelAndView  modelAndView){
	        modelAndView.setViewName("dashboard");
	        usuarioController.achaTodosUsuarios(modelAndView);
	        return modelAndView;
	    }
	 
}
