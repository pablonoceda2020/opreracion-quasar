package com.opreracion.quasar.communications.exceptions;

import com.opreracion.quasar.communications.model.response.DataResponse;

public class CommunicationException extends Exception {

	private static final long serialVersionUID = 1L;

	public CommunicationException(String errorMessage) {
		super(errorMessage);
	}

	public DataResponse faltaInfo() {
		DataResponse resp= new DataResponse();
		resp.setMessage("No hay suficiente información.");
		return resp;
	}
}
