package hu.todomanager.weblayer.servlet;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import org.apache.log4j.Logger;
import java.io.IOException;
import javax.servlet.http.*;
import hu.todomanager.ejbservice.domain.*;
import hu.todomanager.ejbservice.exception.FacadeException;
import hu.todomanager.ejbservice.facade.*;
import hu.todomanager.weblayer.common.*;

@WebServlet("/newTodo")
public class NewTodoController extends HttpServlet implements TodoParameter{

	private static final Logger LOGGER = Logger.getLogger(NewTodoController.class);
	
	@EJB
	private PriorityFacade priorityFacade;
	@EJB
	private CategoryFacade categoryFacade;
	@EJB
	private TodoFacade todoFacade;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PriorityStub> priorities = new ArrayList<PriorityStub>();
		List<CategoryStub> categories = new ArrayList<CategoryStub>();
		try {
			priorities = this.priorityFacade.getAllPriority();
			categories = this.categoryFacade.getAllCategory();
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		this.forward(request, response, priorities, categories);
	}
	
	private void forward(final HttpServletRequest request, final HttpServletResponse response,
			List<PriorityStub> priorities, List<CategoryStub> categories)
			throws ServletException, IOException {
		request.setAttribute("priorities", priorities);
		request.setAttribute("categories", categories);
		final RequestDispatcher view = request.getRequestDispatcher(Page.TODO_NEW.getJspName());
		view.forward(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String name = request.getParameter(NAME);
		final String description = request.getParameter(DESCRIPTION);
		final String priority = request.getParameter(PRIORITIES);
		final String category = request.getParameter(CATEGORIES);
		final String[] selectedPriorities = request.getParameterValues("selPriorities");
		final String[] selectedCategories = request.getParameterValues("selCategories");
		final String[] selectedSubTodos = request.getParameterValues("selSubTodos");
		LOGGER.info(name);
		
		List<PriorityStub> priorities = new ArrayList<PriorityStub>();
		List<CategoryStub> categories = new ArrayList<CategoryStub>();
		try {
			priorities = this.priorityFacade.getAllPriority();
			categories = this.categoryFacade.getAllCategory();
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		if (name == null || "".equals(name) || selectedPriorities == null || selectedCategories == null) {
			final TodoStub todo = null;
			this.forward(request, response, priorities, categories);
		} else {
			TodoStub todo = new TodoStub(name, description, 0, new Date());
			try {
				this.todoFacade.addTodo(todo, selectedPriorities, selectedCategories, selectedSubTodos);
			} catch (final FacadeException e) {
				LOGGER.error(e, e);
			}
			this.forward(request, response, priorities, categories);
		}
	}
}


