package com.poseidon.advices;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class AtributosClasse {

	private String metodoNome;
	
	private String argumentos;

	public static AtributosClasse  builderAtributosClasse(JoinPoint joinPoint ){
		AtributosClasse atributosClasse = new AtributosClasse();
		Signature signature = joinPoint.getSignature();
	    String methodName = signature.getName();
        String arguments = Arrays.toString(joinPoint.getArgs());
        atributosClasse.setMetodoNome(methodName);
        atributosClasse.setArgumentos(arguments);
		return atributosClasse;
	};
	
	public String getMetodoNome() {
		return metodoNome;
	}

	public void setMetodoNome(String metodoNome) {
		this.metodoNome = metodoNome;
	}

	public String getArgumentos() {
		return argumentos;
	}

	public void setArgumentos(String argumentos) {
		this.argumentos = argumentos;
	}

	@Override
	public String toString() {
		return "AtributosDeClasse [metodoNome=" + metodoNome + ", argumentos=" + argumentos + "]";
	}
	
}
