
package com.poseidon.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poseidon.model.AtributosClasse;

@Component
@Aspect
public class MetricAdvice {

	private DateTime beforeMethodExecution=null;
	
	private DateTime afterMethodExecution=null;
	
	@Autowired
	private LogAspects logAspects;
	
	@Before("execution(* com.poseidon.*..*(..))")
	public void createTimeBeforeMethodExecution(JoinPoint joinPoint) {
		beforeMethodExecution= new DateTime();
	}
	

	@After("execution(* com.poseidon.*..*(..))")
	public void calculatesMethodExecutionTime(JoinPoint joinPoint){
		AtributosClasse atributosClasse = AtributosClasse.builderAtributosClasse(joinPoint);
		Logger logger = logAspects.createLog(joinPoint);
		
		afterMethodExecution= new DateTime();
		
		Integer tempoGasto= afterMethodExecution.getMillisOfSecond()-beforeMethodExecution.getMillisOfSecond();
		
		logger.info("Tempo Gasto: "+ tempoGasto+" millisegundos, "+ atributosClasse);
	}
	

}
