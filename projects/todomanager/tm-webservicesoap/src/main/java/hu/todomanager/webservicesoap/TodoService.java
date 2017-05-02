package hu.todomanager.webservicesoap;

import java.util.List;

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

@WebService(name = "Todo", serviceName = "TodoService", targetNamespace = "http://www.tm.hu/Todomanager")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class TodoService {

	@EJB
	private TodoFacade todoFacade;

	
	@WebMethod(action = "http://www.tm.hu/Todomanager/listAllTodo", operationName = "ListAllTodos")
	@WebResult(name = "Todos")
	public List<TodoStub> listAllTodos() throws FacadeException {
		try {
			return this.todoFacade.getAllTodo();
		} catch (final FacadeException e) {
			throw new FacadeException(e.getMessage());
		}
	}

	
	
}