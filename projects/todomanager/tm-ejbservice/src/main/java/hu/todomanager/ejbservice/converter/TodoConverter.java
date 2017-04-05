package hu.todomanager.ejbservice.converter;

import java.util.List;
import javax.ejb.Local;
import hu.todomanager.ejbservice.domain.TodoStub;
import hu.todomanager.persistence.entity.Todo;

@Local
public interface TodoConverter {

	TodoStub to(Todo todo);
	
	List<TodoStub> allTo(List<Todo> todos);
}
