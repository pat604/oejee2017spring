package hu.balzska.footballtracker.weblayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.balzska.footballtracker.ejbservice.domain.MatchStub;
import hu.balzska.footballtracker.ejbservice.exception.FacadeException;
import hu.balzska.footballtracker.ejbservice.facade.MatchFacade;

@WebServlet("/MatchTest")
public class MatchTestServlet extends HttpServlet {

	private static final long serialVersionUID = -7058255202709402208L;

	@EJB
	private MatchFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		final PrintWriter out = response.getWriter();
		try {
			final MatchStub match = this.facade.getMatch(1);
			out.println(match.toString());
		} catch (final FacadeException e) {
			out.println(e.getLocalizedMessage());
		}
		out.close();
	}

}

