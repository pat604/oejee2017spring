package hu.todomanager.ejbservice.facade;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;
import hu.todomanager.ejbservice.domain.*;
import hu.todomanager.ejbservice.exception.*;

public interface TodoFacade {

	TodoStub getTodo(Long id) throws FacadeException;
	
	TodoStub getTodoByName(String name) throws FacadeException;
	
	List<TodoStub> getAllTodo() throws FacadeException;
	
	void addTodo(TodoStub todo, String[] priorities, String[] categories, String[] subTodos) throws FacadeException;

	void updateTodo(TodoStub todo, String[] priorities, String[] categories, String[] subTodos) throws FacadeException;

	void deleteTodo(String todoName) throws FacadeException;

	List<CategoryStub> getCategories(String todoName) throws FacadeException;

	List<PriorityStub> getPriorities(String todoName) throws FacadeException;

	void setSubTodos(TodoStub todoStub) throws FacadeException;
}
