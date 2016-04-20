package com.poseidon.advices;

import com.poseidon.exception.MethodDeclarationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Method;

@Component
@Aspect
public class ControllerThrowsAdvice {

	@Before("execution(* com.poseidon.*.*Controller..*(..))")
	public void validateThrowsonController(JoinPoint joinPoint) {
		final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		
		Controller annotation = joinPoint.getTarget().getClass().getAnnotation(Controller.class);
				
		if(annotation == null){
			return;
		}
	
		
		Class<?>[] exceptionTypes = method.getExceptionTypes();
		
		if(exceptionTypes != null && exceptionTypes.length>0){
			throw new MethodDeclarationException("Nao pode declarar throws em um com.poseidon.controller.Controller: "+method.getName());
		}
		
	}

}
