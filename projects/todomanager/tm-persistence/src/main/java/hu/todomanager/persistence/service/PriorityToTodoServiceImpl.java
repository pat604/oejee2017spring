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

import hu.todomanager.persistence.entity.PriorityToTodo;
import hu.todomanager.persistence.exception.PersistenceServiceException;
import hu.todomanager.persistence.parameter.TodoParameter;
import hu.todomanager.persistence.query.PriorityToTodoQuery;

@Stateless(mappedName = "ejb/priorityToTodoService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PriorityToTodoServiceImpl implements PriorityToTodoService {
	
	private static final Logger LOGGER = Logger.getLogger(PriorityToTodoServiceImpl.class);

	@PersistenceContext(unitName = "tm-persistence-unit")
	private EntityManager entityManager;

	@Override
	public List<PriorityToTodo> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Priority To Todos");
		}
		List<PriorityToTodo> result = null;
		try {
			result = this.entityManager.createNamedQuery(PriorityToTodoQuery.GET_ALL, PriorityToTodo.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Priority To Todos! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public void add(Long todoId, Long priorityId) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Add PriorityToTodo");
		}
		try {
			this.entityManager.persist(new PriorityToTodo(priorityId, todoId));
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when adding prioToTodo! " + e.getLocalizedMessage(), e);
		}
	}
}
