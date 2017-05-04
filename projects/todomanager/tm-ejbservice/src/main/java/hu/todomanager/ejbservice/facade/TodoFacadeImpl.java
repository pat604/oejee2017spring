package hu.todomanager.ejbservice.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;

import hu.todomanager.ejbservice.exception.AdaptorException;
import hu.todomanager.ejbservice.util.ApplicationError;
import hu.todomanager.ejbservice.converter.*;
import hu.todomanager.ejbservice.domain.*;
import hu.todomanager.ejbservice.exception.*;
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
		List<SubTodo> subTodos = null;
		try {
			Todo todo = this.todoService.read(id);
			final TodoStub stub = this.converter.to(todo);
			subTodos = subTodoService.readAll();
			for (int i = 0; i < subTodos.size(); i++) {
				mapper.setTodoStubSubTodos(todo.getId(), stub, subTodos);
			}

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
	public TodoStub getTodoByName(String name) throws FacadeException{
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
				mapper.setTodoStubSubTodos(todos.get(i).getId(), stubs.get(i), subTodos);
			}
			
			return stubs;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
	
	@Override
	public void addTodo(TodoStub todo, String[] priorities, String[] categories, String[] subTodos) throws FacadeException {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Add Todo");
			}
			todoService.addTodo(new Todo(todo.getName(), todo.getDescription(), todo.getState(), todo.getDeadline()));
			Long todoId = todoService.readByName(todo.getName()).getId();
			
			LOGGER.info("todoId: " + todoId);

			if(priorities != null){
				for (int i = 0; i < priorities.length; i++) {
					Long priorityId = priorityService.readByName(priorities[i]).getId();
					priorityToTodoService.add(todoId, priorityId);
					
				}
			}

			if(categories != null){
				for (int i = 0; i < categories.length; i++) {
					Long categoryId = categoryService.readByName(categories[i]).getId();
					categoryToTodoService.add(todoId, categoryId);
				}
			}
			
			if(subTodos != null){
				for (int i = 0; i < subTodos.length; i++) {
					String[] sTodo = subTodos[i].split("::un1qe::");
					String name = sTodo[0];
					String desc = sTodo[1];
					LOGGER.info("name: " + name + " desc: " + desc);
					subTodoService.add(new SubTodo(todoId, name, desc, 0));
				}
			}
			
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
		
	@Override
	public void updateTodo(TodoStub todo, String[] priorities, String[] categories, String[] subTodos) throws FacadeException {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Update Todo");
			}
			todoService.update(new Todo(todo.getName(), todo.getDescription(), todo.getState(), todo.getDeadline()));
			Long todoId = todoService.readByName(todo.getName()).getId();
			LOGGER.info("todoId: " + todoId);

			if(priorities != null){
				for (int i = 0; i < priorities.length; i++) {
					Long priorityId = priorityService.readByName(priorities[i]).getId();
					priorityToTodoService.add(todoId, priorityId);
				}
			}
			if(categories != null){
				for (int i = 0; i < categories.length; i++) {
					Long categoryId = categoryService.readByName(categories[i]).getId();
					categoryToTodoService.add(todoId, categoryId);
				}
			}
			if(subTodos != null){
				for (int i = 0; i < subTodos.length; i++) {
					String[] sTodo = subTodos[i].split("::un1qe::");
					String name = sTodo[0];
					String desc = sTodo[1];
					subTodoService.add(new SubTodo(todoId, name, desc, 0));
				}
			}
			
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public void deleteTodo(String todoName) throws FacadeException {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Delete Todo");
			}
			Long todoId = todoService.readByName(todoName).getId();
			priorityToTodoService.remove(todoId);
			categoryToTodoService.remove(todoId);
			subTodoService.remove(todoId);
			todoService.remove(todoId);
			
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public List<CategoryStub> getCategories(String todoName) throws FacadeException{
		List<Category> categories = null;
		List<CategoryToTodo> categoryToTodos = null;
		Todo todo = null;
		List<CategoryStub> stubs = null;
		try {
			todo = this.todoService.readByName(todoName);
			categories = categoryService.readAll();
			categoryToTodos = categoryToTodoService.readAll();
			
			stubs = mapper.getTodoCategories(todo.getId(), categories, categoryToTodos);
			
			return stubs;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public List<PriorityStub> getPriorities(String todoName) throws FacadeException{
		List<Priority> priorities = null;
		List<PriorityToTodo> priorityToTodos = null;
		Todo todo = null;
		List<PriorityStub> stubs = null;
		try {
			todo = this.todoService.readByName(todoName);
			priorities = priorityService.readAll();
			priorityToTodos = priorityToTodoService.readAll();
			
			stubs = mapper.getTodoPriorities(todo.getId(), priorities, priorityToTodos);
			
			return stubs;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public void setSubTodos(TodoStub todoStub) throws FacadeException{
		List<SubTodo> subTodos = null;
		Todo todo = null;
		List<SubTodoStub> stubs = null;
		try {
			todo = this.todoService.readByName(todoStub.getName());
			subTodos = subTodoService.readAll();
			mapper.setTodoStubSubTodos(todo.getId(), todoStub, subTodos);
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
}
