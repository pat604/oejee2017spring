package hu.todomanager.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import hu.todomanager.ejbservice.domain.*;
import hu.todomanager.ejbservice.converter.*;
import hu.todomanager.persistence.entity.*;
import org.apache.log4j.Logger;

@Stateless
public class Mapper {
	
	private static final Logger LOGGER = Logger.getLogger(Mapper.class);
	
	@EJB
	private SubTodoConverter subTodoConverter;
	
	public void setTodoStubPriority(Long todoId, TodoStub todoStub,
			List<Priority> priorities, List<PriorityToTodo> priorityToTodos){
		List<Integer> priorityIds = new ArrayList<Integer>();
		for (PriorityToTodo priorityToTodo : priorityToTodos) {
			if(priorityToTodo.getTodoId() == todoId){
				priorityIds.add((int)priorityToTodo.getPriorityId());
			}
		}
		PriorityStub todoPriority = null;
		for (Priority priority : priorities) {
			if(priorityIds.size() > 0 && (int)priority.getId() == priorityIds.get(0)){
				todoPriority = new PriorityStub(priority.getName(), priority.getPriorityValue());
				break;
			}
		}
		todoStub.setPriority(todoPriority);
	}
	
	public void setTodoStubSubTodos(long todoId, TodoStub todoStub,
			List<SubTodo> subTodos){
		for (SubTodo subTodo : subTodos) {
			if(subTodo.getTodoId() == todoId){
				todoStub.addSubTodo(subTodoConverter.to(subTodo));
			}
		}
	}
}
