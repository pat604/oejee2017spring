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


@WebServlet("/LoginError")
public class LoginErrorServlet extends HttpServlet implements LoginAttribute {


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String userName = request.getParameter("j_username");

		request.setAttribute(ATTR_USERNAME, userName);
		request.setAttribute(ATTR_ERROR, "Login failed");

		final RequestDispatcher view = request.getRequestDispatcher(Page.LOGIN.getJspName());
		view.forward(request, response);
	}

}
