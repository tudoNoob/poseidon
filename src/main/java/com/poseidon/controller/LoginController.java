package com.poseidon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.model.User;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView buildLogionPage(ModelAndView modelAndView){
		modelAndView.getModelMap().addAttribute("user", new User());
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
}
