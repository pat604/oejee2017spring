package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.GuitarBrandStub;
import domain.GuitarStub;
import facade.GuitarFacade;

@WebServlet("/GuitarPing")
public class GuitarPingServlet extends HttpServlet {

	@EJB
	private GuitarFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<GuitarStub> guitar = this.facade.getGuitars(GuitarBrandStub.GIBSON);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(guitar.toString());
		out.close();
	}

}
