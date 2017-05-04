package com.kota.stratagem.ejbservice.protocol;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.kota.stratagem.ejbservice.converter.ObjectiveConverter;
import com.kota.stratagem.ejbservice.exception.AdaptorException;
import com.kota.stratagem.ejbserviceclient.ObjectiveProtocolRemote;
import com.kota.stratagem.ejbserviceclient.domain.ObjectiveRepresentor;
import com.kota.stratagem.ejbserviceclient.exception.ServiceException;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;
import com.kota.stratagem.persistence.service.ObjectiveService;

@Stateless(mappedName = "ejb/objectiveProtocol")
public class ObjectiveProtocolImpl implements ObjectiveProtocol, ObjectiveProtocolRemote {

	private static final Logger LOGGER = Logger.getLogger(ObjectiveProtocolImpl.class);

	@EJB
	private ObjectiveService objectiveService;

	@EJB
	private ObjectiveConverter converter;

	@Override
	public ObjectiveRepresentor getObjective(Long id) throws ServiceException {
		try {
			final ObjectiveRepresentor representor = this.converter.to(this.objectiveService.read(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Objective (id: " + id + ") --> " + representor);
			}
			return representor;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new ServiceException(e.getLocalizedMessage());
		}
	}

	@Override
	public List<ObjectiveRepresentor> getAllObjectives() throws AdaptorException {
		List<ObjectiveRepresentor> representors = new ArrayList<ObjectiveRepresentor>();
		try {
			representors = this.converter.to(this.objectiveService.readAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Fetch all Objectives : " + representors.size() + " objective(s)");
			}
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
		}
		return representors;
	}

}
