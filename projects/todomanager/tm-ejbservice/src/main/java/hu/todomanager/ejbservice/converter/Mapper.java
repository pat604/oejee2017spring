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

	public List<PriorityStub> getTodoPriorities(Long todoId,
			List<Priority> priorities, List<PriorityToTodo> priorityToTodos){
		List<Integer> priorityIds = new ArrayList<Integer>();
		for (PriorityToTodo priorityToTodo : priorityToTodos) {
			if(priorityToTodo.getTodoId() == todoId){
				priorityIds.add((int)priorityToTodo.getPriorityId());
			}
		}
		List<PriorityStub> priorityStubs = new ArrayList<PriorityStub>();
		for (Integer id : priorityIds) {
			for (Priority priority : priorities) {
				if(priorityIds.size() > 0 && (int)priority.getId() == id){
					priorityStubs.add(new PriorityStub(priority.getName(), priority.getPriorityValue()));
				}
			}
		}
		return priorityStubs;
	}

	public List<CategoryStub> getTodoCategories(Long todoId,
			List<Category> categories, List<CategoryToTodo> categoryToTodos){
		List<Integer> categoryIds = new ArrayList<Integer>();
		for (CategoryToTodo categoryToTodo : categoryToTodos) {
			if(categoryToTodo.getTodoId() == todoId){
				categoryIds.add((int)categoryToTodo.getCategoryId());
			}
		}
		List<CategoryStub> categoryStubs = new ArrayList<CategoryStub>();
		for (Integer id : categoryIds) {
			for (Category category : categories) {
				if(categoryIds.size() > 0 && (int)category.getId() == id){
					categoryStubs.add(new CategoryStub(category.getName(), category.getDescription()));
				}
			}
		}
		return categoryStubs;
	}

	/*
	public List<SubTodoStub> getSubTodos(Long todoId, List<SubTodo> subTodos){
		List<SubTodoStub> subTodoStubs = new ArrayList<SubTodoStub>();
		for (SubTodo subTodo : subTodos) {
			if(subTodo.getTodoId() == todoId){
				subTodoStubs.add(new SubTodoStub(subTodo.getName(), subTodo.getDescription(), subTodo.getState()));
			}
		}
		return subTodoStubs;
	}
	*/
	
	public void setTodoStubSubTodos(long todoId, TodoStub todoStub,
			List<SubTodo> subTodos){
		for (SubTodo subTodo : subTodos) {
			if(subTodo.getTodoId() == todoId){
				todoStub.addSubTodo(subTodoConverter.to(subTodo));
			}
		}
	}
}
