package hu.todomanager.ejbservice.facade;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;
import hu.todomanager.ejbservice.domain.CategoryStub;
import hu.todomanager.ejbservice.exception.FacadeException;

public interface CategoryFacade {
	
	CategoryStub getCategoryByName(String name) throws FacadeException;
	
	List<CategoryStub> getAllCategory() throws FacadeException;
	
	void addCategory(CategoryStub category) throws FacadeException;
}
