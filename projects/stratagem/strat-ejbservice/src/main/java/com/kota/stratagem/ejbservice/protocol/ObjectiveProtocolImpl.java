package com.kota.stratagem.ejbservice.protocol;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.kota.stratagem.ejbservice.converter.ObjectiveConverter;
import com.kota.stratagem.ejbservice.domain.AppUserRepresentor;
import com.kota.stratagem.ejbservice.domain.ObjectiveRepresentor;
import com.kota.stratagem.ejbservice.exception.AdaptorException;
import com.kota.stratagem.ejbservice.util.ApplicationError;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;
import com.kota.stratagem.persistence.service.ObjectiveService;

@Stateless
public class ObjectiveProtocolImpl implements ObjectiveProtocol {

	private static final Logger LOGGER = Logger.getLogger(ObjectiveProtocolImpl.class);

	@EJB
	private ObjectiveService objectiveService;
	
	@EJB
	private ObjectiveConverter converter;

	@Override
	public ObjectiveRepresentor getObjective(Long id) throws AdaptorException {
		try {
			final ObjectiveRepresentor representor = this.converter.to(this.objectiveService.read(id));
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Objective (id: " + id + ") --> " + representor);
			}
			return representor;
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new AdaptorException(ApplicationError.UNEXPECTED, e.getLocalizedMessage());
		}
	}

	@Override
	public List<ObjectiveRepresentor> getAllObjectives() throws AdaptorException {
		List<ObjectiveRepresentor> representors = new ArrayList<ObjectiveRepresentor>();
		try {
			representors = this.converter.to(this.objectiveService.readAll());
			if(LOGGER.isDebugEnabled()) {
				LOGGER.debug("Fetch all Objectives : " + representors.size() + " objective(s)");
			}
		} catch(final PersistenceServiceException e) {
			LOGGER.error(e, e);
		}
		return representors;
	}
	
}
