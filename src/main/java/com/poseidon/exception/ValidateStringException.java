package com.poseidon.exception;

public class ValidateStringException extends PoseidonException {

	public ValidateStringException() {

	}

	public ValidateStringException(String message) {
		super(message);

	}

	public ValidateStringException(Throwable cause) {
		super(cause);

	}

	public ValidateStringException(String message, Throwable cause) {
		super(message, cause);

	}

	public ValidateStringException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
