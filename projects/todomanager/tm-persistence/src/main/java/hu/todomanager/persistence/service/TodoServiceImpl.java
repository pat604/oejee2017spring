package hu.todomanager.persistence.service;

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
import hu.todomanager.persistence.entity.Todo;
import hu.todomanager.persistence.exception.PersistenceServiceException;
import hu.todomanager.persistence.parameter.TodoParameter;
import hu.todomanager.persistence.query.TodoQuery;

@Stateless(mappedName = "ejb/todoService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TodoServiceImpl implements TodoService {

	private static final Logger LOGGER = Logger.getLogger(TodoServiceImpl.class);

	@PersistenceContext(unitName = "tm-persistence-unit")
	private EntityManager entityManager;

	@Override
	public Todo read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Todo by id (" + id + ")");
		}
		Todo result = null;
		try {
			result = this.entityManager.createNamedQuery(TodoQuery.GET_BY_ID, Todo.class).setParameter(TodoParameter.ID, id).getSingleResult();
			LOGGER.info("Todo name: (" + result.getName() + ")");
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Todo by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public Todo readByName(String name) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Todo by name (" + name + ")");
		}
		Todo result = null;
		try {
			result = this.entityManager.createNamedQuery(TodoQuery.GET_BY_NAME, Todo.class).setParameter(TodoParameter.NAME, name).getSingleResult();
			LOGGER.info("Todo name: (" + result.getName() + ")");
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Todo by name (" + name + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public List<Todo> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get sub todos");
		}
		List<Todo> result = null;
		try {
			result = this.entityManager.createNamedQuery(TodoQuery.GET_ALL, Todo.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching todos! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public void addTodo(Todo todo) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Add Todo");
		}
		try {
			final Todo newTodo = new Todo(todo.getName(), todo.getDescription(), todo.getState(), todo.getDeadline());
			LOGGER.info("XXXXXXXXXXXXXXXXXXX");
			LOGGER.info(newTodo);
			LOGGER.info(newTodo.getDeadline());
			this.entityManager.persist(newTodo);
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when adding todo! " + e.getLocalizedMessage(), e);
		}
	}

}
