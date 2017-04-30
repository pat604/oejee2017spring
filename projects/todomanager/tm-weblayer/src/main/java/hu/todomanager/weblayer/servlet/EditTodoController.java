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

@WebServlet("/editTodo")
public class EditTodoController extends HttpServlet{

	private static final Logger LOGGER = Logger.getLogger(EditTodoController.class);
	
	@EJB
	private TodoFacade todoFacade;
	@EJB
	private PriorityFacade priorityFacade;
	@EJB
	private CategoryFacade categoryFacade;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TodoStub todo = null;
		String todoName = request.getParameter("todoName");
		List<PriorityStub> priorities = new ArrayList<PriorityStub>();
		List<CategoryStub> categories = new ArrayList<CategoryStub>();
		List<PriorityStub> todoPriorities = new ArrayList<PriorityStub>();
		List<CategoryStub> todoCategories = new ArrayList<CategoryStub>();
		try {
			todo = this.todoFacade.getTodoByName(todoName);
			priorities = this.priorityFacade.getAllPriority();
			categories = this.categoryFacade.getAllCategory();
			todoPriorities = this.todoFacade.getPriorities(todoName);
			todoCategories = this.todoFacade.getCategories(todoName);
			this.todoFacade.setSubTodos(todo);
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		
		this.forward(request, response, todo, priorities, categories, todoPriorities, todoCategories);
	}
	
	private void forward(final HttpServletRequest request, final HttpServletResponse response, final TodoStub todo,
	List<PriorityStub> priorities, List<CategoryStub> categories, List<PriorityStub> todoPriorities, List<CategoryStub> todoCategories)
			throws ServletException, IOException {
		request.setAttribute("todo", todo);
		request.setAttribute("priorities", priorities);
		request.setAttribute("categories", categories);
		request.setAttribute("todoPriorities", todoPriorities);
		request.setAttribute("todoCategories", todoCategories);
		final RequestDispatcher view = request.getRequestDispatcher(Page.TODO_EDIT.getJspName());
		view.forward(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String name = request.getParameter("name");
		final String description = request.getParameter("description");
		final String priority = request.getParameter("priorities");
		final String category = request.getParameter("categories");
		final String[] selectedPriorities = request.getParameterValues("selPriorities");
		final String[] selectedCategories = request.getParameterValues("selCategories");
		final String[] selectedSubTodos = request.getParameterValues("selSubTodos");
		
		List<PriorityStub> priorities = new ArrayList<PriorityStub>();
		List<CategoryStub> categories = new ArrayList<CategoryStub>();
		List<PriorityStub> todoPriorities = new ArrayList<PriorityStub>();
		List<CategoryStub> todoCategories = new ArrayList<CategoryStub>();
		TodoStub todo = null;

		try {
			todo = this.todoFacade.getTodoByName(name);
			todo.setDescription(description);

			this.todoFacade.updateTodo(todo, selectedPriorities, selectedCategories, selectedSubTodos);

			priorities = this.priorityFacade.getAllPriority();
			categories = this.categoryFacade.getAllCategory();
			todoPriorities = this.todoFacade.getPriorities(name);
			todoCategories = this.todoFacade.getCategories(name);
			this.todoFacade.setSubTodos(todo);
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		this.forward(request, response, todo, priorities, categories, todoPriorities, todoCategories);
	}
	
}
