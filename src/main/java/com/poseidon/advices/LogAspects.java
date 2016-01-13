package com.poseidon.advices;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.poseidon.model.AtributosClasse;

@Aspect
@Component
public class LogAspects {

	

	@Before("execution(* com.poseidon.*..*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		Logger LOGGER = createLog(joinPoint);
		AtributosClasse atributosClasse = criaAtributosClasse(joinPoint);
		LOGGER.info("Accessing {} os argumentos passados foram: {}", joinPoint.getSignature().toShortString(),
				atributosClasse.getArgumentos());
	}

	private AtributosClasse criaAtributosClasse(JoinPoint joinPoint) {
		return AtributosClasse.builderAtributosClasse(joinPoint);
	}

	public Logger createLog(JoinPoint joinPoint) {
		Logger LOGGER = LoggerFactory.getLogger(joinPoint.getSignature().getName());
		return LOGGER;
	}

	@AfterThrowing(pointcut = "execution(* com.poseidon.*..*(..))", throwing = "e")
	public void afterThrowingAdvice(JoinPoint joinPoint, Throwable e) {
		Logger LOGGER = createLog(joinPoint);
		AtributosClasse atributosClasse = criaAtributosClasse(joinPoint);

		LOGGER.info("Foi lancada uma excecao no metodo:" + atributosClasse.getMetodoNome()
				+ " com os seguintes argumentos: " + atributosClasse.getArgumentos() + "\nand  exception: "
				+ e.getMessage(), e);
	}
	
	@AfterReturning(pointcut = "execution(* com.poseidon.*..*(..))", returning = "result")
	public void afterReturningLogAdvice(JoinPoint joinPoint, Object result) {
		Logger LOGGER = createLog(joinPoint);
		AtributosClasse atributosClasse = criaAtributosClasse(joinPoint);
		LOGGER.info(atributosClasse.toString() +" return args: "+result.toString());
	}

}
