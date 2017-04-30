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
import hu.todomanager.persistence.entity.SubTodo;
import hu.todomanager.persistence.exception.PersistenceServiceException;
import hu.todomanager.persistence.parameter.TodoParameter;
import hu.todomanager.persistence.query.SubTodoQuery;

@Stateless(mappedName = "ejb/subTodoService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class SubTodoServiceImpl implements SubTodoService {
	
	private static final Logger LOGGER = Logger.getLogger(SubTodoServiceImpl.class);

	@PersistenceContext(unitName = "tm-persistence-unit")
	private EntityManager entityManager;

	@Override
	public List<SubTodo> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get sub todos");
		}
		List<SubTodo> result = null;
		try {
			result = this.entityManager.createNamedQuery(SubTodoQuery.GET_ALL, SubTodo.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching sub todos! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public void add(SubTodo subTodo) throws PersistenceServiceException{
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Add SubTodo");
		}
		try {
			final SubTodo newSubTodo = new SubTodo(subTodo.getTodoId(), subTodo.getName(), subTodo.getDescription(), subTodo.getState());
			this.entityManager.persist(newSubTodo);
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when adding subTodo! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void update(SubTodo subTodo) throws PersistenceServiceException{
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Update SubTodo");
		}
		try {
			this.entityManager.merge(subTodo);
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when updating subTodo! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void remove(Long todoId) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Delete SubTodoToTodo");
		}
		try {
			this.entityManager.createNamedQuery(SubTodoQuery.REMOVE_BY_TODO).setParameter(TodoParameter.ID, todoId).executeUpdate();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when removing subTodo! " + e.getLocalizedMessage(), e);
		}
	}
}
