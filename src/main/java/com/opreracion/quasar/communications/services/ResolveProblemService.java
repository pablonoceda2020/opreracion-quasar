package com.opreracion.quasar.communications.services;

import com.opreracion.quasar.communications.exceptions.CommunicationException;
import com.opreracion.quasar.communications.model.request.SatelliteRequest;
import com.opreracion.quasar.communications.model.request.ListSatellitesRequest;
import com.opreracion.quasar.communications.model.response.DataResponse;

public interface ResolveProblemService {

	DataResponse messageData(ListSatellitesRequest satellites) throws CommunicationException;

	DataResponse addMessage(SatelliteRequest satellite, String name) throws CommunicationException;

	DataResponse getMessageData() throws CommunicationException;

}
