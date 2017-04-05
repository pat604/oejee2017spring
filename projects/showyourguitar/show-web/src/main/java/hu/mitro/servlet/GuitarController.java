package hu.mitro.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.mitro.ejbservice.domain.GuitarStub;
import hu.mitro.ejbservice.facade.GuitarFacade;

@WebServlet("/Guitar")
public class GuitarController extends HttpServlet {

	@EJB
	private GuitarFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);

		Long id = Long.valueOf(request.getParameter("id"));
		try {
			GuitarStub guitar = this.facade.getGuitar(id);
			request.setAttribute("guitar", guitar);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher view = request.getRequestDispatcher("guitar.jsp");
		view.forward(request, response);
	}

}
