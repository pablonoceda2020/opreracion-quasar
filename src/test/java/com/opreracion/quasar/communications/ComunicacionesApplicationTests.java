package com.opreracion.quasar.communications;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.opreracion.quasar.communications.exceptions.CommunicationException;
import com.opreracion.quasar.communications.model.request.SatelliteRequest;
import com.opreracion.quasar.communications.model.request.SatellitesRequest;
import com.opreracion.quasar.communications.model.response.DataResponse;
import com.opreracion.quasar.communications.model.response.PositionResponse;
import com.opreracion.quasar.communications.services.ResolveProblemService;

@SpringBootTest
class ComunicacionesApplicationTests {

	@Autowired
	ResolveProblemService resolveProblemService;

	@Test
	void obtenerMensajeOriginalOk() {
		SatellitesRequest satellites = generarReqOk();
		DataResponse dataResp = null;
		PositionResponse respuestaEsperada = new PositionResponse();
		respuestaEsperada.setX(-58.32);
		respuestaEsperada.setY(-69.55);
		String mensajeEsperado = "auxilio motor roto";

		try {
			dataResp = resolveProblemService.messageData(satellites);
			assertNotEquals(null, dataResp);
		} catch (CommunicationException e) {

		}

		assertTrue(mensajeEsperado.equalsIgnoreCase(dataResp.getMessage()));
		assertTrue(respuestaEsperada.getX()==dataResp.getPosition().getX());
		assertTrue(respuestaEsperada.getY()==dataResp.getPosition().getY());
	}

	@Test
	void fallaMensajeIncompleto() {
		SatellitesRequest satellites = generarReqMensajeIncompleto();

		DataResponse dataResp = null;
		try {
			dataResp = resolveProblemService.messageData(satellites);
		} catch (CommunicationException e) {

		}
		assertNull(dataResp);
	}

	private SatellitesRequest generarReqOk() {
		SatellitesRequest satellites = new SatellitesRequest();
		List<SatelliteRequest> satellitesList = new ArrayList<>();

		// "auxilio motor roto"
		satellitesList.add(datosDelSatelite("kenobi", 100, "", "motor", ""));
		satellitesList.add(datosDelSatelite("skywalker", 115.5, "auxilio", "", ""));
		satellitesList.add(datosDelSatelite("sato", 142.7, "", "", "roto"));

		satellites.setSatellites(satellitesList);
		return satellites;
	}

	private SatellitesRequest generarReqMensajeIncompleto() {
		SatellitesRequest satellites = new SatellitesRequest();
		List<SatelliteRequest> satellitesList = new ArrayList<>();

		// "auxilio roto"
		satellitesList.add(datosDelSatelite("kenobi", 1000, "", "", "roto"));
		satellitesList.add(datosDelSatelite("skywalker", 400, "auxilio", "", ""));
		satellitesList.add(datosDelSatelite("sato", 0, "", "", "roto"));

		satellites.setSatellites(satellitesList);
		return satellites;
	}

	private SatelliteRequest datosDelSatelite(String nombre, double distancia, String pat1, String pat2, String pat3) {
		SatelliteRequest satellite = new SatelliteRequest();
		List<String> message = null;

		satellite.setName(nombre);
		satellite.setDistance(distancia);
		message = new ArrayList<>();

		message.add(pat1);
		message.add(pat2);
		message.add(pat3);

		satellite.setMessage(message);
		return satellite;
	}

}
