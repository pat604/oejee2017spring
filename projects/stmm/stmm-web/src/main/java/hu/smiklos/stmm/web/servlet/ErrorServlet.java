package hu.smiklos.stmm.web.servlet;



import hu.smiklos.stmm.web.common.Page;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Error")
public class ErrorServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final RequestDispatcher view = request.getRequestDispatcher(Page.ERROR.getJspName());
		view.forward(request, response);
	}

}
