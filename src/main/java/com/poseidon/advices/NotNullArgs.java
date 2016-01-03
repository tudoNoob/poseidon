package com.poseidon.advices;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Esta annotation eh apra validar os parametros de um metodo se eles sao nulos.
 * 
 * @author ahrons
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NotNullArgs {

	/**
	 * Este atributo é para deixar que algum parametro em algum metodo seja
	 * null,para isto eh preciso por o numero da declaracao deste atributo no
	 * metedo. O numero sempre ira comecar com 0.
	 * 
	 * @throws NumberCastException,
	 *             NotNullException
	 */
	public String[] nullArgs() default "";
}
