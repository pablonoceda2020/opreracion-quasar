package com.opreracion.quasar.communications.model.request;

import java.util.ArrayList;
import java.util.List;

public class ListSatellitesRequest {

	private List<SatelliteRequest> satellites;

	public ListSatellitesRequest() {
		super();
	}

	public List<SatelliteRequest> getSatellites() {
		if (this.satellites == null) {
			this.satellites = new ArrayList<>();
		}
		return satellites;
	}

	public void setSatellites(List<SatelliteRequest> satellites) {
		this.satellites = satellites;
	}

	@Override
	public String toString() {
		return "SatellitesRequest [satellites=" + satellites + "]";
	}

}
