package hu.todomanager.ejbservice.converter;

import java.util.List;
import javax.ejb.Local;
import hu.todomanager.ejbservice.domain.SubTodoStub;
import hu.todomanager.persistence.entity.SubTodo;

@Local
public interface SubTodoConverter {

	SubTodoStub to(SubTodo subTodo);
}
