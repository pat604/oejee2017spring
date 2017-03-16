package hu.qwaevisz.tickethandling.weblayer.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

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
		final String id = request.getParameter(ID);
		LOGGER.info("Get Ticket by ID (" + id + ")");
		if (id == null || "".equals(id)) {
			response.sendRedirect(Page.LIST.getUrl());
		} else {
			final boolean editFlag = TRUE_VALUE.equals(request.getParameter(EDIT_FLAG));
			TicketStub ticket = null;
			boolean isNew = false;
			if (NEW_TICKET_ID_FLAG.equals(id)) {
				//ticket = new TicketStub("", "", "", BCategoryStub.SCIFI, 1000, 10);
				//isNew = true;
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
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		
		final String id = request.getParameter(ID);
		final String system = request.getParameter(SYSTEM);
		final String sender_name = request.getParameter(SENDER_NAME);
		final PriorityStub priority = PriorityStub.valueOf(request.getParameter(PRIORITY));
		final String business_impact = request.getParameter(BUSINESS_IMPACT);
		final String steps_to_rep = request.getParameter(STEPS_TO_REP);
		final Date creationdate = format.parse(request.getParameter(CREATION_DATE));
		final Integer level = Integer.parseInt(request.getParameter(LEVEL));
		final String processor = request.getParameter(PROCESSOR); 
		final StatusStub status = StatusStub.valueOf(request.getParameter(STATUS));
		final Date lastchanged = format.parse(request.getParameter(LAST_CHANGED));	
		
		if (id == null || "".equals(id)) {
			final TicketStub ticket = new TicketStub(id, system, sender_name, priority, business_impact, steps_to_rep, creationdate, level, processor, status, lastchanged);
			this.forward(request, response, true, ticket, true);
		} else {
			TicketStub ticket = null;
			try {
				ticket = this.facade.saveTicket(id, system, sender_name, priority, business_impact, steps_to_rep, creationdate, level, processor, status, lastchanged);
			} catch (final FacadeException e) {
				LOGGER.error(e, e);
			}
			this.forward(request, response, false, ticket, false);
		}
		
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
