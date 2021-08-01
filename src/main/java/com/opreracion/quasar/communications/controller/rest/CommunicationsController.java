package com.opreracion.quasar.communications.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opreracion.quasar.communications.exceptions.CommunicationException;
import com.opreracion.quasar.communications.model.request.SatellitesRequest;
import com.opreracion.quasar.communications.model.response.DataResponse;
import com.opreracion.quasar.communications.services.ResolveProblemService;

@RestController
public class CommunicationsController {

	@Autowired
	ResolveProblemService resolveProblemService;

	@RequestMapping(method = RequestMethod.POST, value= "/topsecret", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DataResponse> topSecret(@Validated @RequestBody SatellitesRequest satellites) {

		try {
			DataResponse dataResp = resolveProblemService.messageData(satellites);
			return new ResponseEntity<DataResponse>(dataResp, HttpStatus.OK);
		} catch (CommunicationException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}
}
