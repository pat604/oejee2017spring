package hu.todomanager.ejbservice.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;
import hu.todomanager.ejbservice.converter.*;
import hu.todomanager.ejbservice.domain.CategoryStub;
import hu.todomanager.ejbservice.exception.FacadeException;
import hu.todomanager.persistence.entity.*;
import hu.todomanager.persistence.service.*;
import hu.todomanager.persistence.exception.PersistenceServiceException;


@Stateless(mappedName = "ejb/categoryFacade")
public class CategoryFacadeImpl implements CategoryFacade {
	
	private static final Logger LOGGER = Logger.getLogger(CategoryFacadeImpl.class);
	
	@EJB
	private CategoryService service;

	@EJB
	private CategoryConverter converter;

	
	@Override
	public CategoryStub getCategoryByName(String name) throws FacadeException {
		try {
			final CategoryStub stub = this.converter.to(this.service.readByName(name));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Category by name (" + name + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
	
	@Override
	public List<CategoryStub> getAllCategory() throws FacadeException {
		List<Category> categories = null;
		try {
			categories = service.readAll();
			final List<CategoryStub> stubs = this.converter.allTo(categories);
			return stubs;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
	
	@Override
	public void addCategory(CategoryStub todo) throws FacadeException {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Add Category");
			}
			service.addCategory(new Category());
			
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
}
