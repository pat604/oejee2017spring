package hu.qwaevisz.tickethandling.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.qwaevisz.tickethandling.ejbservice.domain.TicketCriteria;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub;
import hu.qwaevisz.tickethandling.ejbservice.exception.AdaptorException;
import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;
import hu.qwaevisz.tickethandling.ejbservice.facade.TicketFacade;

@Stateless
public class TicketRestServiceBean implements TicketRestService {

	private static final Logger LOGGER = Logger.getLogger(StudentRestServiceBean.class);

	@EJB
	private TicketFacade facade;

	@Override
	public List<TicketStub> getTickets() throws AdaptorException, FacadeException {
		LOGGER.info("Get all Tickets");
		return this.facade.getTickets(new TicketCriteria());
	}

	@Override
	public List<TicketStub> getTickets(Integer level) throws AdaptorException, FacadeException {
		LOGGER.info("Get Tickets by level (" + level + ")");
		TicketCriteria criteria = new TicketCriteria();
		criteria.setLevel(level);
		return this.facade.getTickets(new TicketCriteria());
	}

	@Override
	public List<TicketStub> getTickets(TicketCriteria criteria) throws AdaptorException, FacadeException {
		LOGGER.info("Get all Tickets");
		return this.facade.getTickets(new TicketCriteria());
	}
}
