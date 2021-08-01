package com.opreracion.quasar.communications.model.response;

public class PositionResponse {

	private double x;
	private double y;

	public PositionResponse() {
		super();
	}

	public PositionResponse(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
