package hu.todomanager.persistence.service;

import javax.ejb.Local;
import java.util.List;
import hu.todomanager.persistence.entity.Category;
import hu.todomanager.persistence.exception.PersistenceServiceException;

@Local
public interface CategoryService {
	Category readByName(String name) throws PersistenceServiceException;
	
	List<Category> readAll() throws PersistenceServiceException;
	
	void addCategory(Category category) throws PersistenceServiceException;
}
