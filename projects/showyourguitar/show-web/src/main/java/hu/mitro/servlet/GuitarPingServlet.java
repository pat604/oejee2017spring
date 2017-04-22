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

import org.apache.log4j.Logger;

import hu.mitro.ejbservice.domain.GuitarStub;
import hu.mitro.ejbservice.exception.FacadeException;
import hu.mitro.ejbservice.facade.GuitarFacade;

@WebServlet("/GuitarPing")
public class GuitarPingServlet extends HttpServlet {

	@EJB
	private GuitarFacade facade;

	private static final Logger LOGGER = Logger.getLogger(GuitarPingServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("Get Guitar by user");
		List<GuitarStub> guitars = null;
		try {
			guitars = this.facade.getGuitars();
		} catch (FacadeException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(guitars.toString());
		out.close();
	}

}
