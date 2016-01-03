package com.poseidon.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class NotNullArgsProcess {

	
	 @Before("execution(* com.poseidon.*..*(..))")
	    public void logServiceAccess(JoinPoint joinPoint) {
	      
		 final MethodSignature methodSignature = (MethodSignature) joinPoint
					.getSignature();
			Method method = methodSignature.getMethod();

			 NotNullArgs annotation = method.getAnnotation(NotNullArgs.class);

			if(annotation== null){
				return;
			}
			
			Object[] args = joinPoint.getArgs();
			
			for(int i =0; i< args.length;i++){
				if(args[i] == null){
					throw new NullPointerException("argumento null, numero da ordem de declracao no metodo: "+i);
				}
			}
			
	    }
	
}
