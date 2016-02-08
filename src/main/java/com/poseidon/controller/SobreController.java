package com.poseidon.controller;

import com.poseidon.annotation.ViewName;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SobreController {
	
	@RequestMapping("/sobre")
	@ViewName(name = "sobre")
	 public ModelAndView sobre(ModelAndView modelAndView){
		 return modelAndView;
	 }
}
