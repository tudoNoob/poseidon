package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.annotation.ViewName;

@Controller
public class SobreController {
	
	@RequestMapping("/sobre")
	@ViewName(name = "sobre")
	 public ModelAndView sobre(ModelAndView modelAndView){
		 return modelAndView;
	 }
}
