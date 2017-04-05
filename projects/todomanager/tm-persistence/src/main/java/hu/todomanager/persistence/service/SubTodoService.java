package hu.todomanager.persistence.service;

import javax.ejb.Local;
import java.util.List;
import hu.todomanager.persistence.entity.SubTodo;
import hu.todomanager.persistence.exception.PersistenceServiceException;

@Local
public interface SubTodoService {
	List<SubTodo> readAll() throws PersistenceServiceException;
}
