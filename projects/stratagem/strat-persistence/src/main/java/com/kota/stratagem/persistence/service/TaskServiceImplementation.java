package com.kota.stratagem.persistence.service;

import java.util.List;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.kota.stratagem.persistence.entity.Task;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;
import com.kota.stratagem.persistence.query.TaskQuery;

@Stateless(mappedName = "ejb/taskService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TaskServiceImplementation implements TaskService {

	private static final Logger LOGGER = Logger.getLogger(TaskServiceImplementation.class);
	
	@PersistenceContext(unitName = "strat-persistence-unit")
	private EntityManager entityManager;
	
	@EJB
	private TaskService taskService;
	
	@Override
	public List<Task> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Fetching all tasks");
		}
		List<Task> result = null;
		try {
			result = this.entityManager.createNamedQuery(TaskQuery.GET_ALL_TASKS, Task.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error occured while fetching tasks" + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
}