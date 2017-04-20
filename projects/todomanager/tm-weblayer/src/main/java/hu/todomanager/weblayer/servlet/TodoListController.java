package hu.todomanager.weblayer.servlet;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import org.apache.log4j.Logger;
import java.io.IOException;
import javax.servlet.http.*;
import hu.todomanager.ejbservice.domain.TodoStub;
import hu.todomanager.ejbservice.exception.FacadeException;
import hu.todomanager.ejbservice.facade.TodoFacade;
import hu.todomanager.weblayer.common.Page;

@WebServlet("/todoList")
public class TodoListController extends HttpServlet{

	private static final Logger LOGGER = Logger.getLogger(TodoListController.class);

	@EJB
	private TodoFacade facade;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TodoStub> todos = new ArrayList<TodoStub>(); 
		try {
			todos = this.facade.getAllTodo();
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		this.forward(request, response, todos, null, false);
	}
	
	private void forward(final HttpServletRequest request, final HttpServletResponse response,
	final List<TodoStub> todos, final TodoStub selectedTodo, final boolean editFlag)
			throws ServletException, IOException {
		request.setAttribute("todos", todos);
		request.setAttribute("todo", selectedTodo);
		final RequestDispatcher view = request.getRequestDispatcher(editFlag ? Page.TODO_EDIT.getJspName() : Page.LIST.getJspName());
		view.forward(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
	throws ServletException, IOException {
		final String type = request.getParameter("type");
		final String todoName = request.getParameter("todoName");
		
		if("delete".equals(type)){
			try {
				this.facade.deleteTodo(todoName);
			} catch (final FacadeException e) {
				LOGGER.error(e, e);
			}
			
			List<TodoStub> todos = new ArrayList<TodoStub>(); 
			try {
				todos = this.facade.getAllTodo();
			} catch (final FacadeException e) {
				LOGGER.error(e, e);
			}
			this.forward(request, response, todos, null, false);
		}
		else if("edit".equals(type)){
			TodoStub selectedTodo = null;
			try {
				selectedTodo = this.facade.getTodoByName(todoName);
			} catch (final FacadeException e) {
				LOGGER.error(e, e);
			}
			this.forward(request, response, null, selectedTodo, true);
		}
	}
}
