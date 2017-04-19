package hu.todomanager.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import hu.todomanager.ejbservice.domain.SubTodoStub;
import hu.todomanager.persistence.entity.SubTodo;

@Stateless
public class SubTodoConverterImpl implements SubTodoConverter {

	@Override
	public SubTodoStub to(SubTodo subTodo) {
		return new SubTodoStub(subTodo.getName(), subTodo.getDescription(), subTodo.getState());
	}
}
