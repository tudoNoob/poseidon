package com.poseidon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {
	 @RequestMapping("/dashboard")
	    public ModelAndView home(ModelAndView  modelAndView){
	        modelAndView.setViewName("dashboard");
	        return modelAndView;
	    }
	 
}
