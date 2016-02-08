package com.poseidon.controller;

import com.poseidon.annotation.ViewName;
import com.poseidon.model.ContaView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("/loginPage")
	@ViewName(name="login")
	public ModelAndView buildLoginPage(ModelAndView modelAndView){
		modelAndView.getModelMap().addAttribute("user", new ContaView());
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
