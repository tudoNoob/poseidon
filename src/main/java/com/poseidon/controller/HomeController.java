package com.poseidon.controller;

import com.poseidon.annotation.ViewName;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user/")
public class HomeController {

	@RequestMapping("/homePage")
	@ViewName(name = "home")
	public ModelAndView home(ModelAndView modelAndView) {
		return modelAndView;
	}

	@RequestMapping("/")
	@ViewName(name = "redirect:homePage")
	public ModelAndView defaultUrl(ModelAndView modelAndView) {
		return modelAndView;
	}

}
