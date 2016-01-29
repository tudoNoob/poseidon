package com.poseidon.exception;

public class PoseidonException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PoseidonException() {

	}

	public PoseidonException(String message) {
		super(message);

	}

	public PoseidonException(Throwable cause) {
		super(cause);

	}

	public PoseidonException(String message, Throwable cause) {
		super(message, cause);

	}

	public PoseidonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
