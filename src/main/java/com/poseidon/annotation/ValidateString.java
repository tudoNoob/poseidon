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

	public int minLength() default 2;
	
}
