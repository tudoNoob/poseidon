package com.poseidon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.annotation.ViewName;
import com.poseidon.model.ContaView;

@Controller
public class LoginController {

	@RequestMapping("/login")
	@ViewName(name="login")
	public ModelAndView buildLoginPage(ModelAndView modelAndView){
		modelAndView.getModelMap().addAttribute("user", new ContaView());
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping("/login-Error")
	@ViewName(name="login")
	public ModelAndView buildLoginErrorPage(ModelAndView modelAndView){
		modelAndView.getModelMap().addAttribute("user", new ContaView());
		modelAndView.getModelMap().addAttribute("error", true);
		return modelAndView;
	}
	
}
