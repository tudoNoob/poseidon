package com.poseidon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.annotation.ValidateArgs;
import com.poseidon.annotation.ViewName;

@Controller
public class HomeController {

	@RequestMapping("/home")
	@ViewName(name = "home")
	public ModelAndView home(ModelAndView modelAndView) {
		return modelAndView;
	}

}
