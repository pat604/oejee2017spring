package hu.todomanager.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import hu.todomanager.ejbservice.domain.CategoryStub;
import hu.todomanager.persistence.entity.Category;

@Stateless
public class CategoryConverterImpl implements CategoryConverter {

	@Override
	public CategoryStub to(Category category) {
		return new CategoryStub(category.getName(), category.getDescription());
	}
	
	@Override
	public List<CategoryStub> allTo(List<Category> categories) {
		List<CategoryStub> stubs = new ArrayList<CategoryStub>();
		for (Category category : categories) {
			stubs.add(new CategoryStub(category.getName(), category.getDescription()));
		}
		return stubs;
	}
}
