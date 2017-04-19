package hu.todomanager.persistence.service;

import javax.ejb.Local;
import java.util.List;
import hu.todomanager.persistence.entity.Priority;
import hu.todomanager.persistence.exception.PersistenceServiceException;

@Local
public interface PriorityService {
	Priority readByName(String name) throws PersistenceServiceException;
	
	List<Priority> readAll() throws PersistenceServiceException;
	
	void addPriority(Priority priority) throws PersistenceServiceException;
}
