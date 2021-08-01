package com.opreracion.quasar.communications.services.impl;

import java.util.List;

import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.opreracion.quasar.communications.exceptions.CommunicationException;
import com.opreracion.quasar.communications.helper.Util;
import com.opreracion.quasar.communications.model.request.SatelliteRequest;
import com.opreracion.quasar.communications.model.request.SatellitesRequest;
import com.opreracion.quasar.communications.model.response.DataResponse;
import com.opreracion.quasar.communications.model.response.PositionResponse;
import com.opreracion.quasar.communications.services.ResolveProblemService;

@Service
public class ResolveProblemServiceImpl implements ResolveProblemService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final double[] KENOBI = { -500, -200 };
	private static final double[] SKYWALKER = { 100, -100 };
	private static final double[] SATO = { 500, 100 };
	
	@Autowired
	private Util util;

	@Override
	public DataResponse messageData(SatellitesRequest satellites) throws CommunicationException {
		logger.info("Comienza el proceso de obtener el mensaje y la distancia. Request {}", satellites);
		DataResponse dataResponse = new DataResponse();
		double[][] positions = new double[][] { KENOBI, SKYWALKER, SATO };
		

			dataResponse.setMessage(getMessage(satellites.getSatellites()));

			dataResponse.setPosition(getLocation(util.getDistances(satellites), positions));

		
		logger.info("Finaliza el proceso de obtener el mensaje y la distancia. Request {}", satellites);
		return dataResponse;
	}

	private PositionResponse getLocation(double[] distances, double[][] positions) throws CommunicationException {
		PositionResponse position = new PositionResponse();

		TrilaterationFunction trilaterationFunction = new TrilaterationFunction(positions, distances);
		NonLinearLeastSquaresSolver nSolver = new NonLinearLeastSquaresSolver(trilaterationFunction,
				new LevenbergMarquardtOptimizer());

		double[] location = nSolver.solve().getPoint().toArray();
		position.setX(util.redondearDecimales(location[0], 2));
		position.setY(util.redondearDecimales(location[1], 2));
		return position;
	}

	private String getMessage(List<SatelliteRequest> messages) throws CommunicationException {

		

		return null;
	}

}
