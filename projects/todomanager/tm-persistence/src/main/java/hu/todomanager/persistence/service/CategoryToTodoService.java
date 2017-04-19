package hu.todomanager.persistence.service;

import javax.ejb.Local;
import java.util.List;

import hu.todomanager.persistence.entity.CategoryToTodo;
import hu.todomanager.persistence.exception.PersistenceServiceException;

@Local
public interface CategoryToTodoService {
	List<CategoryToTodo> readAll() throws PersistenceServiceException;
	
	void add(Long todoId, Long categoryId) throws PersistenceServiceException;
}
