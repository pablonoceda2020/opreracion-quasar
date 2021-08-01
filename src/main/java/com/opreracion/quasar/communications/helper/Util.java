package com.opreracion.quasar.communications.helper;

import org.springframework.stereotype.Component;

import com.opreracion.quasar.communications.model.request.SatellitesRequest;

@Component
public class Util {

	public double[] getDistances(SatellitesRequest satellites) {
		double[] positions = new double[satellites.getSatellites().size()];

		for (int i = 0; i < satellites.getSatellites().size(); i++) {
			if (satellites.getSatellites().get(i) != null) {
				positions[i] = satellites.getSatellites().get(i).getDistance();
			}
		}
		return positions;
	}

}
