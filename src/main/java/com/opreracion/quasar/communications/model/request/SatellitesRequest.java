package com.opreracion.quasar.communications.model.request;

import java.util.List;

public class SatellitesRequest {

	private List<SatelliteRequest> satellites;

	public SatellitesRequest() {
		super();
	}

	public List<SatelliteRequest> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<SatelliteRequest> satellites) {
		this.satellites = satellites;
	}

}
