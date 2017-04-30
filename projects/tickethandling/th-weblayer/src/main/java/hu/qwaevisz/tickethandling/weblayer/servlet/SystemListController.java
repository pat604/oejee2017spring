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

import hu.qwaevisz.tickethandling.ejbservice.domain.SystemStub;
import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;
import hu.qwaevisz.tickethandling.ejbservice.facade.SystemFacade;
import hu.qwaevisz.tickethandling.weblayer.common.FormValue;
import hu.qwaevisz.tickethandling.weblayer.common.ListAttribute;
import hu.qwaevisz.tickethandling.weblayer.common.ListParameter;
import hu.qwaevisz.tickethandling.weblayer.common.Page;

@WebServlet("/SystemList")
public class SystemListController extends HttpServlet implements ListAttribute, ListParameter, FormValue {

	private static final long serialVersionUID = -1977646750178615187L;

	private static final Logger LOGGER = Logger.getLogger(TicketListController.class);

	@EJB
	private SystemFacade sysFacade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get All Customers");
		try {
			final List<SystemStub> systems = this.sysFacade.getSystems();
			request.setAttribute(ATTR_SYSTEMS, systems);
		} catch (final FacadeException e) {
			LOGGER.error(e, e);
		}

		final RequestDispatcher view = request.getRequestDispatcher(Page.SYSTEMLIST.getJspName());
		view.forward(request, response);
	}
}
