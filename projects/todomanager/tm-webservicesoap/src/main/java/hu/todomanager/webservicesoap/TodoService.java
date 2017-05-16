package hu.todomanager.webservicesoap;

import java.util.List;
import java.util.Date;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import hu.todomanager.ejbservice.domain.*;
import hu.todomanager.ejbservice.exception.*;
import hu.todomanager.ejbservice.facade.*;
import hu.todomanager.ejbservice.util.Filter;

@WebService(name = "Todo", serviceName = "TodoService", targetNamespace = "http://www.tm.hu/Todomanager")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class TodoService {

	@EJB
	private TodoFacade todoFacade;
	
	private Filter filter = new Filter();

	
	@WebMethod(action = "http://www.tm.hu/Todomanager/listAllTodo", operationName = "ListAllTodos")
	@WebResult(name = "Todos")
	public List<TodoStub> listAllTodos() throws FacadeException {
		try {
			return this.todoFacade.getAllTodo();
		} catch (final FacadeException e) {
			throw new FacadeException(e.getMessage());
		}
	}
	
	@WebMethod(action = "http://www.tm.hu/Todomanager/listTodosByCategory", operationName = "listTodosByCategory")
	@WebResult(name = "Todos")
	public List<TodoStub> listTodosByCategory(
			@WebParam(name = "category") final String category) throws FacadeException {
		try {
			List<TodoStub> todos = this.todoFacade.getAllTodo();
			todos = filter.filterByCategory(todos, category);
			return todos;
		} catch (final FacadeException e) {
			throw new FacadeException(e.getMessage());
		}
	}
	
	@WebMethod(action = "http://www.tm.hu/Todomanager/updateTodo", operationName = "updateTodo")
	public void updateTodo(@WebParam(name = "name") final String name,
			@WebParam(name = "description") final String description,
			@WebParam(name = "deadline") final Date deadline) throws FacadeException {
		try {
			TodoStub todo = new TodoStub(name, description, 0, deadline);
			this.todoFacade.updateTodo(todo, null, null, null);
		} catch (final FacadeException e) {
			throw new FacadeException(e.getMessage());
		}
	}

	
	
}