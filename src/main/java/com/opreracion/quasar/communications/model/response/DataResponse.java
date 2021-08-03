package com.opreracion.quasar.communications.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class DataResponse {

	private PositionResponse position;
	private String message;

	public DataResponse() {
		super();
	}

	public DataResponse(PositionResponse position, String message) {
		super();
		this.position = position;
		this.message = message;
	}

	public PositionResponse getPosition() {
		return position;
	}

	public void setPosition(PositionResponse position) {
		this.position = position;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
