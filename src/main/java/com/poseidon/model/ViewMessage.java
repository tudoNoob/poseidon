package com.poseidon.model;

public class ViewMessage {

	public String error;

	public String success;

	public ViewMessage() {
		this.setError(null);
		this.setSuccess(null);
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "ViewMessage [error=" + error + ", success=" + success + "]";
	}
}
