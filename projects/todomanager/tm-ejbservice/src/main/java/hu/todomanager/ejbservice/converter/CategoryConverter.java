package hu.todomanager.ejbservice.converter;

import java.util.List;
import javax.ejb.Local;
import hu.todomanager.ejbservice.domain.CategoryStub;
import hu.todomanager.persistence.entity.Category;

@Local
public interface CategoryConverter {

	CategoryStub to(Category category);
	
	List<CategoryStub> allTo(List<Category> categories);
}
