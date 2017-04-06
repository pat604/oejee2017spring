package hu.smiklos.stmm.web.servlet;


import hu.smiklos.stmm.web.common.LoginAttribute;
import hu.smiklos.stmm.web.common.Page;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet implements LoginAttribute {



	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(ATTR_USERNAME, "");
		request.setAttribute(ATTR_ERROR, "");
		final RequestDispatcher view = request.getRequestDispatcher(Page.HOME.getJspName());
		view.forward(request, response);
	}

}
