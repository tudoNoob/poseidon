package com.poseidon.advices;

public class AdviceException extends RuntimeException {

	public AdviceException() {
	}

	public AdviceException(String message) {
		super(message);
	}

	public AdviceException(Throwable cause) {
		super(cause);
	}

	public AdviceException(String message, Throwable cause) {
		super(message, cause);
	}

	public AdviceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
