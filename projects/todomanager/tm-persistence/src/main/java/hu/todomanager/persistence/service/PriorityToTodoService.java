package hu.todomanager.persistence.service;

import javax.ejb.Local;
import java.util.List;
import hu.todomanager.persistence.entity.PriorityToTodo;
import hu.todomanager.persistence.exception.PersistenceServiceException;

@Local
public interface PriorityToTodoService {
	List<PriorityToTodo> readAll() throws PersistenceServiceException;
	
	void add(Long todoId, Long priorityId) throws PersistenceServiceException;

	void remove(Long todoId) throws PersistenceServiceException;
}
