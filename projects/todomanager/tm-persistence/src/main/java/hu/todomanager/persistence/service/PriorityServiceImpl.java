package hu.todomanager.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.todomanager.persistence.entity.Priority;
import hu.todomanager.persistence.exception.PersistenceServiceException;
import hu.todomanager.persistence.parameter.TodoParameter;
import hu.todomanager.persistence.query.PriorityQuery;


@Stateless(mappedName = "ejb/priorityService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PriorityServiceImpl implements PriorityService {
	
	private static final Logger LOGGER = Logger.getLogger(PriorityServiceImpl.class);

	@PersistenceContext(unitName = "tm-persistence-unit")
	private EntityManager entityManager;
	
	@Override
	public Priority readByName(String name) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Priority by name (" + name + ")");
		}
		Priority result = null;
		try {
			result = this.entityManager.createNamedQuery(PriorityQuery.GET_BY_NAME, Priority.class).setParameter(TodoParameter.NAME, name).getSingleResult();
			//LOGGER.info("Priority name: (" + result.getName() + ")");
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Priority by name (" + name + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Priority> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Categories.");
		}
		List<Priority> result = null;
		try {
			result = this.entityManager.createNamedQuery(PriorityQuery.GET_ALL, Priority.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Categories! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public void addPriority(Priority priority) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Add Priority");
		}
		try {
			
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when adding priority! " + e.getLocalizedMessage(), e);
		}
	}
}
