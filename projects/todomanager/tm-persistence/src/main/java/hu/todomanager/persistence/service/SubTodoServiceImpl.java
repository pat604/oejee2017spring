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
}
