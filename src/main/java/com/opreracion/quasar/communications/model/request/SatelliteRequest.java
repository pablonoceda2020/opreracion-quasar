package com.opreracion.quasar.communications.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.opreracion.quasar.communications.model.Satellite;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SatelliteRequest extends Satellite {

	private String name;

	public SatelliteRequest() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SatelliteRequest [name=" + name + "]";
	}

}
