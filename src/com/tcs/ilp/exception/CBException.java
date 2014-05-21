package com.tcs.ilp.exception;

/**
 * @author H55 - Group 1 The class defines custom exceptions for the application
 */
public class CBException extends Exception {

	private static final long serialVersionUID = -2727535554364902759L;

	private String cbMessage;

	public CBException(String message) {
		cbMessage = message;
	}

	/*
	 * setCBMessage method is used to set the message to be displayed when an
	 * exception occurs
	 */
	public void setCBMessage(String cbMessage) {
		this.cbMessage = cbMessage;
	}

	public String getCBMessage() {
		return cbMessage;
	}

	public String toString() {
		return null;

	}

}
