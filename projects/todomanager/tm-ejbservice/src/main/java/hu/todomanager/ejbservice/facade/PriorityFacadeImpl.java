package hu.todomanager.ejbservice.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;
import hu.todomanager.ejbservice.converter.*;
import hu.todomanager.ejbservice.domain.PriorityStub;
import hu.todomanager.ejbservice.exception.FacadeException;
import hu.todomanager.persistence.entity.*;
import hu.todomanager.persistence.service.*;
import hu.todomanager.persistence.exception.PersistenceServiceException;


@Stateless(mappedName = "ejb/priorityFacade")
public class PriorityFacadeImpl implements PriorityFacade {
	
	private static final Logger LOGGER = Logger.getLogger(PriorityFacadeImpl.class);
	
	@EJB
	private PriorityService service;

	@EJB
	private PriorityConverter converter;

	
	@Override
	public PriorityStub getPriorityByName(String name) throws FacadeException {
		try {
			final PriorityStub stub = this.converter.to(this.service.readByName(name));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Priority by name (" + name + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
	
	@Override
	public List<PriorityStub> getAllPriority() throws FacadeException {
		List<Priority> priorities = null;
		try {
			priorities = service.readAll();
			final List<PriorityStub> stubs = this.converter.allTo(priorities);
			return stubs;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
	
	@Override
	public void addPriority(PriorityStub todo) throws FacadeException {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Add Priority");
			}
			service.addPriority(new Priority());
			
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
}
