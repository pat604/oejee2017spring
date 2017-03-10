package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookStub;
import facade.BookFacade;

@WebServlet("/BookPing")
public class BookPingServlet extends HttpServlet {

	@EJB
	private BookFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookStub book = this.facade.getBook("978-0441172719");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(book.toString());
		out.close();
	}

}
