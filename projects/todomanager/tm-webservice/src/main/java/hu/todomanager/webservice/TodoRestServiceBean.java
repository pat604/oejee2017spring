package hu.todomanager.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import hu.todomanager.ejbservice.domain.*;
import hu.todomanager.ejbservice.exception.*;
import hu.todomanager.ejbservice.facade.TodoFacade;

@Stateless
public class TodoRestServiceBean implements TodoRestService {

	private static final Logger LOGGER = Logger.getLogger(TodoRestServiceBean.class);

	@EJB
	private TodoFacade facade;

	@Override
	public TodoStub getTodo(final String name) throws FacadeException {
		LOGGER.info("Get Todo (" + name + ")");
		return this.facade.getTodoByName(name);
	}

	
	@Override
	public List<TodoStub> getAllTodo() throws FacadeException {
		LOGGER.info("Get all Todo");
		return this.facade.getAllTodo();
	}
	
	@Override
	public void deleteTodo(final String name) throws FacadeException {
		LOGGER.info("Delete Todo");
		this.facade.deleteTodo(name);
	}

	/*
	@Override
	public void removeStudent(final String neptun) throws AdaptorException {
		LOGGER.info("Remove Student (" + neptun + ")");
		this.facade.removeStudent(neptun);
	}

	@Override
	public void removeStudentAdvanced(final String neptun) throws AdaptorException {
		LOGGER.info("Remove Student Advanced (" + neptun + ")");
		this.facade.removeStudentAdvanced(neptun);
	}

	@Override
	public Response optionsAll(final String path) {
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	*/
}
