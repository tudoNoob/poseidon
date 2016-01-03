package com.poseidon.advices;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.poseidon.exception.NotNullException;

/**
 * Esta classe ira processar a annotation @NotNull em toda a aplicacao.
 * @author ahrons
 * @see NoNullArgs
 */
@Component
@Aspect
public class NotNullArgsProcessAdvice {

	/**
	 * Este metodo ira fazer o processamento da annotation @NotNull
	 * @param joinPoint
	 * @see NotNullArgs
	 */
	@Before("execution(* com.poseidon.*..*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {

		final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();

		NotNullArgs annotation = method.getAnnotation(NotNullArgs.class);

		if (annotation == null) {
			return;
		}

		String[] nullArgs = annotation.nullArgs();

		Object[] args = joinPoint.getArgs();

		for (int i = 0; i < args.length; i++) {
			if (!validatePositionArgs(i, nullArgs)) {
				if (args[i] == null) {
					throw new NotNullException("argumento null, numero da ordem de declracao no metodo: " + i);
				}
			}
		}

	}

	private Boolean validatePositionArgs(int i, String[] nullArgs) {
		if(nullArgs[0].isEmpty()){
			return false;
		}
		for (int j = 0; j < nullArgs.length; j++) {
				if (i == Integer.parseInt(nullArgs[j])) {
					return true;
				}
			}
		return false;
	}
}
