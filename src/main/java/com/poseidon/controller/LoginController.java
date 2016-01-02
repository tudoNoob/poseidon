package com.poseidon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.model.UserView;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView buildLogionPage(ModelAndView modelAndView){
		modelAndView.getModelMap().addAttribute("user", new UserView());
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping("/login-Error")
	public ModelAndView buildLogionErrorPage(ModelAndView modelAndView){
		modelAndView.getModelMap().addAttribute("user", new UserView());
		modelAndView.getModelMap().addAttribute("error", true);
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
}
