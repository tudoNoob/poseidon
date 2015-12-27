package com.poseidon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SobreController {
	@RequestMapping("/sobre")
	 public ModelAndView sobre(ModelAndView modelAndView){
		 modelAndView.setViewName("sobre");
		 return modelAndView;
	 }
}
