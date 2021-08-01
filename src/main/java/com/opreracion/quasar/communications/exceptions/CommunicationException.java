package com.opreracion.quasar.communications.exceptions;

public class CommunicationException extends Exception {

	private static final long serialVersionUID = 1L;

	public CommunicationException(String errorMessage) {
		super(errorMessage);
	}

}
