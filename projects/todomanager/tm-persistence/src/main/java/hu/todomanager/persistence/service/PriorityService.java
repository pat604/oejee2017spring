package hu.todomanager.persistence.service;

import javax.ejb.Local;
import java.util.List;

import hu.todomanager.persistence.entity.Priority;
import hu.todomanager.persistence.exception.PersistenceServiceException;

@Local
public interface PriorityService {
	List<Priority> readAll() throws PersistenceServiceException;
}
