package hu.qwaevisz.tickethandling.persistence.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.qwaevisz.tickethandling.persistence.entity.Component;
import hu.qwaevisz.tickethandling.persistence.exception.PersistenceServiceException;
import hu.qwaevisz.tickethandling.persistence.parameter.ComponentParameter;
import hu.qwaevisz.tickethandling.persistence.query.ComponentQuery;

@Stateless(mappedName = "ejb/componentService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ComponentServiceImpl implements ComponentService {

	private static final Logger LOGGER = Logger.getLogger(ComponentServiceImpl.class);

	@PersistenceContext(unitName = "th-persistence-unit")
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public boolean exists(String id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Check if Component exists by ID (" + id + ")");
		}
		try {

			final Long result = this.entityManager.createNamedQuery(ComponentQuery.COUNT_BY_ID, Long.class).setParameter(ComponentParameter.ID, id)
					.getSingleResult();
			return result != 0;

		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error getting Component by ID (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public Component read(String id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Check Component by ID (" + id + ")");
		}
		Component result = null;
		try {
			result = this.entityManager.createNamedQuery(ComponentQuery.GET_BY_ID, Component.class).setParameter(ComponentParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error getting Component by ID (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Component> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Components");
		}
		List<Component> result = null;
		try {
			result = this.entityManager.createNamedQuery(ComponentQuery.GET_ALL, Component.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Components! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Component create(String id, String description, Date creationdate) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Create Component with id (" + id + ")");
		}
		try {
			final Component comp = new Component(id, description, creationdate);
			this.entityManager.persist(comp);
			return comp;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting Component with id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void delete(String id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Remove Component by id (" + id + ")");
		}
		try {
			this.entityManager.createNamedQuery(ComponentQuery.REMOVE_BY_ID).setParameter(ComponentParameter.ID, id).executeUpdate();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when removing Component by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}

}
