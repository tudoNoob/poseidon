package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.annotation.ViewName;
import com.poseidon.model.UserView;

@Controller
public class LoginController {

	@RequestMapping("/login")
	@ViewName(name="login")
	public ModelAndView buildLogionPage(ModelAndView modelAndView){
		modelAndView.getModelMap().addAttribute("user", new UserView());
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping("/login-Error")
	@ViewName(name="login")
	public ModelAndView buildLogionErrorPage(ModelAndView modelAndView){
		modelAndView.getModelMap().addAttribute("user", new UserView());
		modelAndView.getModelMap().addAttribute("error", true);
		return modelAndView;
	}
	
}
