package hu.todomanager.weblayer.servlet;

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

@WebServlet("/todo")
public class TodoController extends HttpServlet{

	private static final Logger LOGGER = Logger.getLogger(TodoController.class);
	
	@EJB
	private TodoFacade facade;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TodoStub todo = null;
		try {
			Long id = 1L;
			todo = this.facade.getTodo(id);
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		
		//resp.setContentType("text/plain");
		//resp.getWriter().println(todo.toString());
		this.forward(request, response, false, todo, false);
	}
	
	private void forward(final HttpServletRequest request, final HttpServletResponse response, final boolean editFlag, final TodoStub todo, boolean isNew)
			throws ServletException, IOException {
		request.setAttribute("todo", todo);
		//request.setAttribute(ATTR_ISNEW, isNew);
		final RequestDispatcher view = request.getRequestDispatcher(Page.TODO_EDIT.getJspName());
		view.forward(request, response);
	}
	
}
