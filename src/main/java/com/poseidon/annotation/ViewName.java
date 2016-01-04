package com.poseidon.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Esta annotation eh para settar o nome da view no objeto modelAndVeiw do spring. Esta annotation tem o intuito de deixar o codigo mais limpo.
 * @author ahrons
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ViewName {

	/**
	 * Atributo que referencia o nome da view que o metodo ira retornar.
	 * 
	 */
	public String name() default "";
}
