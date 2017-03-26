package hu.qwaevisz.tickethandling.weblayer.servlet;

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

import hu.qwaevisz.tickethandling.ejbservice.domain.PriorityStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.StatusStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketCriteria;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub;
import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;
import hu.qwaevisz.tickethandling.ejbservice.facade.TicketFacade;
import hu.qwaevisz.tickethandling.weblayer.common.FormValue;
import hu.qwaevisz.tickethandling.weblayer.common.ListAttribute;
import hu.qwaevisz.tickethandling.weblayer.common.ListParameter;
import hu.qwaevisz.tickethandling.weblayer.common.Page;

@WebServlet("/TicketList")
public class TicketListController extends HttpServlet implements ListAttribute, ListParameter, FormValue {

	private static final long serialVersionUID = -1977646750178615187L;

	private static final Logger LOGGER = Logger.getLogger(TicketListController.class);

	@EJB
	private TicketFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get All Tickets");
		try {
			final List<TicketStub> tickets = this.facade.getTickets(new TicketCriteria());
			request.setAttribute(ATTR_TICKETS, tickets);
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		this.forward(request, response, new TicketCriteria(), FILTER_ALL_SYSTEM);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String systemName = request.getParameter(SYSTEM);
		final TicketCriteria criteria = new TicketCriteria();
		if (!systemName.equals(FILTER_ALL_SYSTEM)) {
			criteria.setSystem(systemName);
		}
		this.forward(request, response, criteria, systemName);
	}

	private void forward(final HttpServletRequest request, final HttpServletResponse response, TicketCriteria criteria, String systemValue)
			throws ServletException, IOException {
		try {
			final List<TicketStub> tickets = this.facade.getTickets(criteria);
			request.setAttribute(ATTR_TICKETS, tickets);
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}
		request.setAttribute(ATTR_SYSTEM, systemValue);
		final RequestDispatcher view = request.getRequestDispatcher(Page.LIST.getJspName());
		view.forward(request, response);
	}

}
