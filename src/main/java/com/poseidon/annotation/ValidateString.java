package com.poseidon.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Esta annotation eh para ser posta em cima do atributo que deseja-se validar, esta annotation eh soh apra atributos string.
 * @author ahrons
 * @see ValidateArgs, ValidateAdvice
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ValidateString {

	/**
	 * Este atributo eh o minimo de tamnho da string que o atributo podera ter.
	 * @return
	 */
	public int minLength() default 2;

	/**
	 * Este atributo eh o maximo de tama ho que a string podera ter.
	 * @return
	 */
	public int maxLength() default 100;
}
