package com.kota.stratagem.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.kota.stratagem.persistence.entity.Project;
import com.kota.stratagem.persistence.entity.Task;
import com.kota.stratagem.persistence.exception.PersistenceServiceException;
import com.kota.stratagem.persistence.parameter.TaskParameter;
import com.kota.stratagem.persistence.query.TaskQuery;

@Stateless(mappedName = "ejb/taskService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TaskServiceImplementation implements TaskService {

	private static final Logger LOGGER = Logger.getLogger(TaskServiceImplementation.class);

	@PersistenceContext(unitName = "strat-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Task create(Long id, String description, Project project, double completion) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Create Task (id: " + id + ", description: " + description + ", project: " + project.getName() + ", completion: " + completion + ")");
		}
		try {
			final Task task = new Task(id, description, project, completion);
			this.entityManager.persist(task);
			this.entityManager.flush();
			return task;
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting Task (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public Task read(Long id) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Task by id (" + id + ")");
		}
		Task result = null;
		try {
			result = this.entityManager.createNamedQuery(TaskQuery.GET_BY_ID, Task.class).setParameter(TaskParameter.ID, id).getSingleResult();
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Task by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Task> readAll() throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Fetching all tasks");
		}
		List<Task> result = null;
		try {
			result = this.entityManager.createNamedQuery(TaskQuery.GET_ALL_TASKS, Task.class).getResultList();
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error occured while fetching tasks" + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Task update(Long id, String description, Project project, double completion) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Update Task (id: " + id + ", description: " + description + ", project: " + project.getName() + ", completion: " + completion + ")");
		}
		try {
			final Task task = this.read(id);
			task.setDescription(description);
			task.setProject(project);
			task.setCompletion(completion);
			return this.entityManager.merge(task);
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error when merging Task! " + e.getLocalizedMessage(), e);
		}
	}

	// To be expanded
	@Override
	public void delete(Long id) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Remove Task by id (" + id + ")");
		}
		try {
			this.entityManager.createNamedQuery(TaskQuery.REMOVE_BY_ID).setParameter(TaskParameter.ID, id).executeUpdate();
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error when removing Task by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public boolean exists(Long id) throws PersistenceServiceException {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Check Task by id (" + id + ")");
		}
		try {
			return this.entityManager.createNamedQuery(TaskQuery.COUNT_BY_ID, Long.class).setParameter(TaskParameter.ID, id).getSingleResult() == 1;
		} catch(final Exception e) {
			throw new PersistenceServiceException("Unknown error during counting Tasks by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}

}