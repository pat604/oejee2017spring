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

@WebServlet("/editTodo")
public class EditTodoController extends HttpServlet{

	private static final Logger LOGGER = Logger.getLogger(EditTodoController.class);
	
	@EJB
	private TodoFacade facade;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TodoStub todo = null;
		String todoName = request.getParameter("todoName");
		LOGGER.info("TODONAME %%%%%%%%%%%%%%%%%%%%%%%%%5");
		LOGGER.info(todoName);
		try {
			todo = this.facade.getTodoByName(todoName);
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		
		this.forward(request, response, todo);
	}
	
	private void forward(final HttpServletRequest request, final HttpServletResponse response, final TodoStub todo)
			throws ServletException, IOException {
		request.setAttribute("todo", todo);
		final RequestDispatcher view = request.getRequestDispatcher(Page.TODO_EDIT.getJspName());
		view.forward(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String name = request.getParameter(NAME);
		final String description = request.getParameter(DESCRIPTION);
		/*
		final String priority = request.getParameter(PRIORITIES);
		final String category = request.getParameter(CATEGORIES);
		final String[] selectedPriorities = request.getParameterValues("selPriorities");
		final String[] selectedCategories = request.getParameterValues("selCategories");
		final String[] selectedSubTodos = request.getParameterValues("selSubTodos");
		for (int i = 0; i < selectedSubTodos.length; i++) {
			LOGGER.info(selectedSubTodos[i]);
		}
		
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
		}*/
	}
	
}
