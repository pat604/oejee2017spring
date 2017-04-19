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

import hu.todomanager.persistence.entity.CategoryToTodo;
import hu.todomanager.persistence.exception.PersistenceServiceException;
import hu.todomanager.persistence.parameter.TodoParameter;
import hu.todomanager.persistence.query.CategoryToTodoQuery;

@Stateless(mappedName = "ejb/categoryToTodoService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CategoryToTodoServiceImpl implements CategoryToTodoService {
	
	private static final Logger LOGGER = Logger.getLogger(CategoryToTodoServiceImpl.class);

	@PersistenceContext(unitName = "tm-persistence-unit")
	private EntityManager entityManager;

	@Override
	public List<CategoryToTodo> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Category To Todos");
		}
		List<CategoryToTodo> result = null;
		try {
			result = this.entityManager.createNamedQuery(CategoryToTodoQuery.GET_ALL, CategoryToTodo.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Category To Todos! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public void add(Long todoId, Long categoryId) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Add CategoryToTodo");
		}
		try {
			this.entityManager.persist(new CategoryToTodo(categoryId, todoId));
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when adding categoryToTodo! " + e.getLocalizedMessage(), e);
		}
	}
}
