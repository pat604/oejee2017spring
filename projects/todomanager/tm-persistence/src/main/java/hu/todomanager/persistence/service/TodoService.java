package hu.todomanager.persistence.service;


import javax.ejb.Local;
import java.util.List;
import hu.todomanager.persistence.entity.Todo;
import hu.todomanager.persistence.exception.PersistenceServiceException;

@Local
public interface TodoService {

	Todo read(Long id) throws PersistenceServiceException;
	
	Todo readByName(String name) throws PersistenceServiceException;
	
	List<Todo> readAll() throws PersistenceServiceException;
}