package hu.todomanager.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;
import hu.todomanager.ejbservice.converter.*;
import hu.todomanager.ejbservice.domain.TodoStub;
import hu.todomanager.ejbservice.exception.FacadeException;
import hu.todomanager.persistence.entity.*;
import hu.todomanager.persistence.service.*;
import hu.todomanager.persistence.exception.PersistenceServiceException;


@Stateless(mappedName = "ejb/todoFacade")
public class TodoFacadeImpl implements TodoFacade {
	
	private static final Logger LOGGER = Logger.getLogger(TodoFacadeImpl.class);
	
	@EJB
	private TodoService todoService;
	@EJB
	private SubTodoService subTodoService;
	@EJB
	private CategoryService categoryService;
	@EJB
	private PriorityService priorityService;
	@EJB
	private CategoryToTodoService categoryToTodoService;
	@EJB
	private PriorityToTodoService priorityToTodoService;

	@EJB
	private TodoConverter converter;
	@EJB
	private Mapper mapper;

	@Override
	public TodoStub getTodo(Long id) throws FacadeException {
		try {
			final TodoStub stub = this.converter.to(this.todoService.read(id));
			
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Todo by id (" + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
	
	@Override
	public TodoStub getTodoByName(String name) throws FacadeException {
		try {
			final TodoStub stub = this.converter.to(this.todoService.readByName(name));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Todo by name (" + name + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
	
	@Override
	public List<TodoStub> getAllTodo() throws FacadeException {
		List<Todo> todos = null;
		List<SubTodo> subTodos = null;
		List<Category> categories = null;
		List<Priority> priorities = null;
		List<CategoryToTodo> categoryToTodos = null;
		List<PriorityToTodo> priorityToTodos = null;
		try {
			todos = todoService.readAll();
			subTodos = subTodoService.readAll();
			categories = categoryService.readAll();
			priorities = priorityService.readAll();
			categoryToTodos = categoryToTodoService.readAll();
			priorityToTodos = priorityToTodoService.readAll();
			
			final List<TodoStub> stubs = this.converter.allTo(todos);
			for (int i = 0; i < todos.size(); i++) {
				mapper.setTodoStubPriority(todos.get(i).getId(), stubs.get(i), priorities, priorityToTodos);
			}
			
			return stubs;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
}
