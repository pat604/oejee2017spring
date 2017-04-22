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

import hu.qwaevisz.tickethandling.ejbservice.domain.EmployeeStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketCriteria;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub;
import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;
import hu.qwaevisz.tickethandling.ejbservice.facade.TicketFacade;
import hu.qwaevisz.tickethandling.weblayer.common.FormValue;
import hu.qwaevisz.tickethandling.weblayer.common.ListAttribute;
import hu.qwaevisz.tickethandling.weblayer.common.ListParameter;
import hu.qwaevisz.tickethandling.weblayer.common.Page;

@WebServlet("/Home")
public class HomeController extends HttpServlet implements ListAttribute, ListParameter, FormValue {

	private static final long serialVersionUID = -1977646750178615187L;

	private static final Logger LOGGER = Logger.getLogger(TicketListController.class);

	@EJB
	private TicketFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get Tickets for Home page");
		try {
			EmployeeStub user = this.facade.getEmployee(request.getUserPrincipal().getName());

			TicketCriteria criteria = new TicketCriteria();
			criteria.setProcessorId(user.getId());

			final List<TicketStub> tickets = this.facade.getTickets(criteria);
			request.setAttribute(ATTR_TICKETS, tickets);

			criteria.setProcessorId(null);
			criteria.setLevel(user.getLevel());

			final List<TicketStub> unassigned = this.facade.getTickets(criteria);
			request.setAttribute(ATTR_UNASSIGNED, unassigned);

		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}

		final RequestDispatcher view = request.getRequestDispatcher(Page.HOME.getJspName());
		view.forward(request, response);
	}
}