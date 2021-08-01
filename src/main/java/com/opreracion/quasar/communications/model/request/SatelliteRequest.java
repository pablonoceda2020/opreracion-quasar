package com.opreracion.quasar.communications.model.request;

import java.util.List;

public class SatelliteRequest {

	private String name;
	private double distance;
	private List<String> message;

	public SatelliteRequest() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

}
