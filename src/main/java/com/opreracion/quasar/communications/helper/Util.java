package com.opreracion.quasar.communications.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.opreracion.quasar.communications.model.request.SatellitesRequest;

@Component
public class Util {

	public double[] getDistances(SatellitesRequest satellites) {
		double[] positions = new double[satellites.getSatellites().size()];

		for (int i = 0; i < satellites.getSatellites().size(); i++) {
			positions[i] = satellites.getSatellites().get(i).getDistance();
		}

		return positions;
	}

	public double redondearDecimales(double valorInicial, int numeroDecimales) {
		double parteEntera, resultado;
		resultado = valorInicial;
		parteEntera = Math.floor(resultado);
		resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
		resultado = Math.round(resultado);
		resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
		return resultado;
	}

	public boolean isNullOrEmpty(List<String> list) {

		if (list == null || list.isEmpty()) {
			return true;
		}

		return false;
	}

	public String getPartMissing(int i, List<String> message) {

		if (!message.get(i).isEmpty()) {
			return message.get(i);
		}

		return null;
	}

}
