package hu.todomanager.webservice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import hu.todomanager.ejbservice.domain.*;
import hu.todomanager.ejbservice.exception.*;

@Path("/todo")
public interface TodoRestService {

	@GET
	@Path("/{name}")
	@Produces("application/json")
	TodoStub getTodo(@PathParam("name") String name) throws FacadeException;

	@GET
	@Path("/list")
	@Produces("application/json")
	List<TodoStub> getAllTodo() throws FacadeException;

	@DELETE
	@Path("/delete/{name}")
	void deleteTodo(@PathParam("name") String name) throws FacadeException;
}
