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
import hu.todomanager.weblayer.common.*;

@WebServlet("/newTodo")
public class NewTodoController extends HttpServlet implements TodoParameter{

	private static final Logger LOGGER = Logger.getLogger(NewTodoController.class);
	
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
		this.forward(request, response);
	}
	
	private void forward(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		final RequestDispatcher view = request.getRequestDispatcher(Page.TODO_EDIT.getJspName());
		view.forward(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String name = request.getParameter(NAME);
		final String description = request.getParameter(DESCRIPTION);
		final int priority = Integer.parseInt(request.getParameter(PRIORITY));
		if (name == null || "".equals(name)) {
			final TodoStub todo = null;//new TodoStub(name);
			this.forward(request, response);
		} else {
			TodoStub todo = null;
			try {
				todo = this.facade.addTodo();
			} catch (final FacadeException e) {
				LOGGER.error(e, e);
			}
			this.forward(request, response);
		}
	}
}


