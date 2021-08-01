package com.opreracion.quasar.communications.services;

import com.opreracion.quasar.communications.model.request.SatellitesRequest;
import com.opreracion.quasar.communications.model.response.DataResponse;

public interface ResolveProblemService {

	DataResponse messageData(SatellitesRequest satellites);

}
