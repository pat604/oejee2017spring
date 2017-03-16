package hu.qwaevisz.tickethandling.weblayer.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;
import hu.qwaevisz.tickethandling.ejbservice.facade.TicketFacade;
import hu.qwaevisz.tickethandling.weblayer.common.TicketParameter;
import hu.qwaevisz.tickethandling.weblayer.common.Page;

@WebServlet("/TicketDelete")
public class TicketDeleteServlet extends HttpServlet implements TicketParameter {

	private static final long serialVersionUID = -7688739575153938635L;

	private static final Logger LOGGER = Logger.getLogger(TicketDeleteServlet.class);

	@EJB
	private TicketFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String id = request.getParameter(ID);
		LOGGER.info("Delete Book by id (" + id + ")");
		try {
			this.facade.removeTicket(Long.parseLong(id));
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		response.sendRedirect(Page.LIST.getUrl());
	}

}
