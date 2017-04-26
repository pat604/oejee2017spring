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

import hu.qwaevisz.tickethandling.ejbservice.domain.EmployeeStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub;
import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;
import hu.qwaevisz.tickethandling.ejbservice.facade.TicketFacade;
import hu.qwaevisz.tickethandling.weblayer.common.Page;
import hu.qwaevisz.tickethandling.weblayer.common.TicketAttribute;
import hu.qwaevisz.tickethandling.weblayer.common.TicketParameter;

@WebServlet("/TicketProcess")
public class TicketProcessController extends HttpServlet implements TicketParameter, TicketAttribute {

	private static final long serialVersionUID = -4068275526750462197L;

	private static final Logger LOGGER = Logger.getLogger(TicketController.class);

	@EJB
	private TicketFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			final String id = request.getParameter(ID);
			LOGGER.info("Get Ticket by ID (" + id + ")");

			final TicketStub ticket = this.facade.getTicket(id);
			final EmployeeStub user = this.facade.getEmployee(request.getUserPrincipal().getName());

			this.facade.saveTicket(ticket.getId(), ticket.getSystem(), ticket.getSender_name(), ticket.getPriority(), ticket.getBusiness_impact(),
					ticket.getSteps_to_rep(), ticket.getCreationdate(), ticket.getLevel(), user, ticket.getStatus(), ticket.getLastchanged(),
					ticket.getConversation());

			this.forward(request, response, ticket);
		} catch (FacadeException e) {
			LOGGER.error(e, e);
		}
	}

	private void forward(final HttpServletRequest request, final HttpServletResponse response, final TicketStub ticket) throws ServletException, IOException {
		try {

			request.setAttribute(ATTR_SYSTEMS, this.facade.getSystems());
			request.setAttribute(ATTR_EMPLOYEES, this.facade.getEmployees());
			request.setAttribute(ATTR_TICKET, ticket);

			final RequestDispatcher view = request.getRequestDispatcher(Page.TICKET_VIEW.getJspName());
			view.forward(request, response);

		} catch (FacadeException e) {
			LOGGER.error(e, e);
		}
	}
}
