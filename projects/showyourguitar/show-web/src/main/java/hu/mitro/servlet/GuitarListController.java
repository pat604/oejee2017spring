package hu.mitro.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.mitro.ejbservice.domain.GuitarStub;
import hu.mitro.ejbservice.exception.FacadeException;
import hu.mitro.ejbservice.facade.GuitarFacade;

@WebServlet("/List")
public class GuitarListController extends HttpServlet {

	private static final Logger LOGGER = Logger.getLogger(GuitarListController.class);

	@EJB
	private GuitarFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("Get Guitars");
		List<GuitarStub> guitars = null;
		try {
			guitars = this.facade.getGuitars();
			request.setAttribute("guitars", guitars);
		} catch (FacadeException e) {
			LOGGER.error(e, e);
		}
		RequestDispatcher view = request.getRequestDispatcher("list.jsp");
		view.forward(request, response);
	}

}
