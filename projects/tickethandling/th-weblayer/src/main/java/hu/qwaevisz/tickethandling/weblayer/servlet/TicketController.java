package hu.qwaevisz.tickethandling.weblayer.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.qwaevisz.tickethandling.ejbservice.domain.EmployeeStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.PriorityStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.StatusStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.SystemStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub;
import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;
import hu.qwaevisz.tickethandling.ejbservice.facade.TicketFacade;
import hu.qwaevisz.tickethandling.weblayer.common.Page;
import hu.qwaevisz.tickethandling.weblayer.common.TicketAttribute;
import hu.qwaevisz.tickethandling.weblayer.common.TicketParameter;

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
		final String id = request.getParameter(ID);
		LOGGER.info("Get Ticket by ID (" + id + ")");

		if ("".equals(id)) {
			response.sendRedirect(Page.LIST.getUrl());
		} else {

			final boolean editFlag = TRUE_VALUE.equals(request.getParameter(EDIT_FLAG));
			TicketStub ticket = null;
			boolean isNew = false;
			if (NEW_TICKET_ID_FLAG.equals(id)) {
				ticket = new TicketStub();
				isNew = true;
			} else {
				try {
					ticket = this.facade.getTicket(id);
				} catch (final FacadeException e) {
					LOGGER.error(e, e);
				}
			}
			this.forward(request, response, editFlag, ticket, isNew);
		}
	}

	private void forward(final HttpServletRequest request, final HttpServletResponse response, final boolean editFlag, final TicketStub ticket, boolean isNew)
			throws ServletException, IOException {
		request.setAttribute(ATTR_TICKET, ticket);
		request.setAttribute(ATTR_ISNEW, isNew);
		final RequestDispatcher view = request.getRequestDispatcher(editFlag ? Page.TICKET_EDIT.getJspName() : Page.TICKET_VIEW.getJspName());
		view.forward(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

		try {

			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			SystemStub system;
			EmployeeStub processor;

			system = this.facade.getSystem(request.getParameter(SYSTEM));
			processor = this.facade.getEmployee(request.getParameter(PROCESSOR));

			final String sender_name = request.getParameter(SENDER_NAME);
			final PriorityStub priority = PriorityStub.valueOf(request.getParameter(PRIORITY));
			final String business_impact = request.getParameter(BUSINESS_IMPACT);
			final String steps_to_rep = request.getParameter(STEPS_TO_REP);
			Date creationdate = new Date();

			final String par_creationdate = request.getParameter(CREATION_DATE);
			if (par_creationdate != null) {
				creationdate = format.parse(par_creationdate);
			}

			final Integer level = Integer.parseInt(request.getParameter(LEVEL));

			final StatusStub status = StatusStub.valueOf(request.getParameter(STATUS));
			Date lastchanged = new Date();

			final String par_lastchanged = request.getParameter(LAST_CHANGED);
			if (par_lastchanged != null) {
				lastchanged = format.parse(par_lastchanged);
			}

			String id = request.getParameter(ID);
			if ("".equals(id)) {
				String newId = system + format.format(creationdate);
				id = newId.replace("-", "").replace(":", "").replace(" ", "");
				LOGGER.info(id);
			}

			final TicketStub ticket = new TicketStub(id, system, sender_name, priority, business_impact, steps_to_rep, creationdate, level, processor, status,
					lastchanged);

			LOGGER.info("Saving new ticket: " + ticket.toString());

			this.facade.saveTicket(id, system, sender_name, priority, business_impact, steps_to_rep, creationdate, level, processor, status, lastchanged);

			LOGGER.info("Ticket saved!");

			this.forward(request, response, false, ticket, true);

		} catch (FacadeException e) {
			LOGGER.error(e, e);
		} catch (ParseException e) {
			LOGGER.error(e, e);
		}

	}

}
