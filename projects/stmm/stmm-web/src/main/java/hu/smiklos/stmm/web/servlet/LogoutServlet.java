package hu.smiklos.stmm.web.servlet;



import hu.smiklos.stmm.web.common.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", new java.util.Date().toString());
		if (request.getSession(false) != null) {
			request.getSession(false).invalidate();
		}
		if (request.getSession() != null) {
			request.getSession().invalidate();
		}
		request.logout();
		response.sendRedirect(Page.HOME.getUrl());
	}

}
