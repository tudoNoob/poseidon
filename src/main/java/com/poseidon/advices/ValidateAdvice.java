package com.poseidon.advices;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.poseidon.annotation.ValidateArgs;
import com.poseidon.annotation.ValidateString;
import com.poseidon.exception.IllegalAnnotationPosition;
import com.poseidon.exception.ValidateStringException;

/**
 * Esta classe ira processar as annotations ValidateArgs e ValidateString.
 * 
 * @author ahrons
 * @see ValidateArgs,ValidateString
 */
@Component
@Aspect
public class ValidateAdvice {

	@Before("execution(* com.poseidon.*..*(..))")
	public void validateArgs(JoinPoint joinPoint) throws IllegalArgumentException, IllegalAccessException {

		final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();

		if (!method.isAnnotationPresent(ValidateArgs.class)) {
			return;
		}

		Object[] args = joinPoint.getArgs();

		for (int i = 0; i < args.length; i++) {
			Field[] fields = args[i].getClass().getDeclaredFields();
			for (int j = 0; j < fields.length; j++) {
				if (fields[j].isAnnotationPresent(ValidateString.class)) {
					ValidateString validateString = fields[j].getAnnotation(ValidateString.class);
					if (!fields[j].getType().equals(String.class)) {
						throw new IllegalAnnotationPosition(
								"a annotation ValidateString esta em um atributo que nao eh String.");
					}
					fields[j].setAccessible(true);
					Object object = fields[j].get(args[i]);
					if (object.toString().length() < validateString.minLength() || object.toString().length() > validateString.maxLength() ) {
						throw new ValidateStringException("Erro na validacao da string, do atributo:"+fields[j].getName());
					}
				}
			}
		}
	}

}

