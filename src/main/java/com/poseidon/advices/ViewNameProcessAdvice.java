package com.poseidon.advices;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.poseidon.annotation.ViewName;
import com.poseidon.exception.ViewNameException;
/**
 * Esta classe ira processar a annotation ViewName.
 * @author ahrons
 *
 */
@Component
@Aspect
public class ViewNameProcessAdvice {

	@AfterReturning(pointcut = "execution(* com.poseidon.*.*Controller..*(..)))", returning = "result")
	public void processViewName(JoinPoint joinPoint, Object result) {

		final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();

		ViewName annotation = method.getAnnotation(ViewName.class);
		
		if(annotation == null){
			return;
		}
		
		String errorView = annotation.errorView();
		if(errorView!= null && !errorView.isEmpty()){
			buildModelAndView(result, errorView);
			return;
		}
		
		String name = annotation.name();
		Class<?> returnType = method.getReturnType();
		if(!returnType.isAssignableFrom(ModelAndView.class)){
			throw new ViewNameException("Para usar a annotation @ViewName é preciso que o metodo retorne ModelAndView.");
		}
		buildModelAndView(result, name);
		
	}

	private void buildModelAndView(Object result, String name) {
		ModelAndView modelAndView= (ModelAndView) result;
		modelAndView.setViewName(name);
	}
}
