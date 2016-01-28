package com.poseidon.model;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

public class AtributosClasse {

	private String metodoNome;

	private String argumentos;

	private String returnType;

	public static AtributosClasse builderAtributosClasse(JoinPoint joinPoint) {
		AtributosClasse atributosClasse = new AtributosClasse();
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		String arguments = Arrays.toString(joinPoint.getArgs());
		atributosClasse.setMetodoNome(methodName);
		atributosClasse.setArgumentos(arguments);

		final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		atributosClasse.setReturnType(method.getReturnType().getName());

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

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	@Override
	public String toString() {
		return "AtributosClasse [metodoNome=" + metodoNome + ", argumentos=" + argumentos + ", returnType=" + returnType
				+ "]";
	}
}
