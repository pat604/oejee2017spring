package hu.qwaevisz.tickethandling.weblayer.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.qwaevisz.tickethandling.ejbservice.domain.StatusStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.PriorityStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub;
import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;
import hu.qwaevisz.tickethandling.ejbservice.facade.TicketFacade;
import hu.qwaevisz.tickethandling.weblayer.common.TicketAttribute;
import hu.qwaevisz.tickethandling.weblayer.common.TicketParameter;
import hu.qwaevisz.tickethandling.weblayer.common.Page;

@WebServlet("/Ticket")
public class TicketController extends HttpServlet implements TicketParameter, TicketAttribute {

	private static final long serialVersionUID = -4068275526750462197L;

	private static final Logger LOGGER = Logger.getLogger(TicketController.class);

	private static final String TRUE_VALUE = "1";
	private static final String NEW_TICKET_ID_FLAG = "-1";

	@EJB
	private TicketFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String id = request.getParameter(id);
		LOGGER.info("Get Book by ISBN (" + isbn + ")");
		if (isbn == null || "".equals(isbn)) {
			response.sendRedirect(Page.LIST.getUrl());
		} else {
			final boolean editFlag = TRUE_VALUE.equals(request.getParameter(EDIT_FLAG));
			BookStub book = null;
			boolean isNew = false;
			if (NEW_BOOK_ISBN_FLAG.equals(isbn)) {
				book = new BookStub("", "", "", BookCategoryStub.SCIFI, 1000, 10);
				isNew = true;
			} else {
				try {
					book = this.facade.getBook(isbn);
				} catch (final FacadeException e) {
					LOGGER.error(e, e);
				}
			}
			this.forward(request, response, editFlag, book, isNew);
		}
	}

	private void forward(final HttpServletRequest request, final HttpServletResponse response, final boolean editFlag, final BookStub book, boolean isNew)
			throws ServletException, IOException {
		request.setAttribute(ATTR_BOOK, book);
		request.setAttribute(ATTR_ISNEW, isNew);
		final RequestDispatcher view = request.getRequestDispatcher(editFlag ? Page.BOOK_EDIT.getJspName() : Page.BOOK_VIEW.getJspName());
		view.forward(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String isbn = request.getParameter(ISBN);
		final String author = request.getParameter(AUTHOR);
		final String title = request.getParameter(TITLE);
		final int numberOfPages = Integer.parseInt(request.getParameter(NUMBER_OF_PAGES));
		final double price = Double.parseDouble(request.getParameter(PRICE));
		final BookCategoryStub category = BookCategoryStub.valueOf(request.getParameter(CATEGORY));
		if (isbn == null || "".equals(isbn)) {
			final BookStub book = new BookStub(isbn, author, title, category, price, numberOfPages);
			this.forward(request, response, true, book, true);
		} else {
			BookStub book = null;
			try {
				book = this.facade.saveBook(isbn, author, title, numberOfPages, price, category);
			} catch (final FacadeException e) {
				LOGGER.error(e, e);
			}
			this.forward(request, response, false, book, false);
		}
	}

}
