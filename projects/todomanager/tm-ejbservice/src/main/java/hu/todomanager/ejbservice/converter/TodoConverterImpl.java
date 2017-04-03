package hu.todomanager.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import hu.todomanager.ejbservice.domain.TodoStub;
import hu.todomanager.persistence.entity.Todo;

@Stateless
public class TodoConverterImpl implements TodoConverter {

	@Override
	public TodoStub to(Todo todo) {
		return new TodoStub(todo.getName(), todo.getDescription(), todo.getState(), todo.getDeadline());
	}
	
	@Override
	public List<TodoStub> allTo(List<Todo> todos) {
		List<TodoStub> stubs = new ArrayList<TodoStub>();
		for (Todo todo : todos) {
			stubs.add(new TodoStub(todo.getName(), todo.getDescription(), todo.getState(), todo.getDeadline()));
		}
		return stubs;
	}
}
