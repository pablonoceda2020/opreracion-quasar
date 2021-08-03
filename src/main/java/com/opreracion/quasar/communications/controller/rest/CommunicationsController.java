package com.opreracion.quasar.communications.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opreracion.quasar.communications.exceptions.CommunicationException;
import com.opreracion.quasar.communications.model.request.SatelliteRequest;
import com.opreracion.quasar.communications.model.request.ListSatellitesRequest;
import com.opreracion.quasar.communications.model.response.DataResponse;
import com.opreracion.quasar.communications.services.ResolveProblemService;

@RestController
@RequestMapping(path = "/operacion-qasar")
public class CommunicationsController {

	@Autowired
	ResolveProblemService resolveProblemService;

	@PostMapping(value = "/topsecret/", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DataResponse> topSecret(@RequestBody ListSatellitesRequest satellites) {

		try {
			DataResponse dataResp = resolveProblemService.messageData(satellites);
			return new ResponseEntity<DataResponse>(dataResp, HttpStatus.OK);
		} catch (CommunicationException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(value = "/topsecret_split/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DataResponse> getTopSecret() {

		try {
			DataResponse dataResp = resolveProblemService.getMessageData();
			return new ResponseEntity<DataResponse>(dataResp, HttpStatus.OK);
		} catch (CommunicationException e) {
			return new ResponseEntity<>(e.faltaInfo(), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(path = "/topsecret_split/{name}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DataResponse> topSecretSplit(@PathVariable("name") String name,
			@RequestBody SatelliteRequest satellite) {
		try {
			DataResponse dataResp = resolveProblemService.addMessage(satellite, name);
			return new ResponseEntity<DataResponse>(dataResp, HttpStatus.OK);
		} catch (CommunicationException e) {
			return new ResponseEntity<>(e.faltaInfo(), HttpStatus.NOT_FOUND);
		}

	}
}
