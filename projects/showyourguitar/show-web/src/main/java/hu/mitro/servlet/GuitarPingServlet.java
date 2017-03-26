package hu.mitro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.mitro.domain.GuitarBrandStub;
import hu.mitro.domain.GuitarStub;
import hu.mitro.facade.GuitarFacade;

@WebServlet("/GuitarPing")
public class GuitarPingServlet extends HttpServlet {

	@EJB
	private GuitarFacade facade;

	// private static final Logger LOGGER = Logger.getLogger(GuitarPingServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// LOGGER.info("Get Guitar by user");

		List<GuitarStub> guitar = this.facade.getGuitars(GuitarBrandStub.GIBSON);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(guitar.toString());
		out.close();
	}

}
