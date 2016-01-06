package com.poseidon.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Esta annotation eh para ser usada quando precisa-se validar um bean, passado no parametro do metodo.
 * @author ahrons
 * @see ValidateString, ValidateAdvice
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ValidateArgs {

}
