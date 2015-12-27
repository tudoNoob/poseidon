package com.poseidon;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalAdvice {

	@ExceptionHandler(RuntimeException.class)
	public ModelAndView exceptionHandler(RuntimeException e) {
		return buildModalError();
	}

	private ModelAndView buildModalError() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("500error");
		return modelAndView;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(Exception e) {
		return buildModalError();
	}
}
