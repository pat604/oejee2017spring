package hu.qwaevisz.tickethandling.ejbservice.facade;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.qwaevisz.tickethandling.ejbservice.converter.TicketConverter;
import hu.qwaevisz.tickethandling.ejbservice.domain.PriorityStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.StatusStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketCriteria;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub;
import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;
import hu.qwaevisz.tickethandling.persistence.entity.Ticket;
import hu.qwaevisz.tickethandling.persistence.entity.trunk.Priority;
import hu.qwaevisz.tickethandling.persistence.entity.trunk.Status;
import hu.qwaevisz.tickethandling.persistence.exception.PersistenceServiceException;
import hu.qwaevisz.tickethandling.persistence.service.TicketService;

@Stateless(mappedName = "ejb/tikcetFacade")
public class TicketFacadeImpl implements TicketFacade {

	private static final Logger LOGGER = Logger.getLogger(TicketFacadeImpl.class);

	@EJB
	private TicketService service;

	@EJB
	private TicketConverter converter;

	@Override
	public TicketStub getTicket(String id) throws FacadeException {
		try {
			final TicketStub stub = this.converter.to(this.service.read(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Ticket by id (" + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public List<TicketStub> getTickets(TicketCriteria criteria) throws FacadeException {
		List<TicketStub> stubs = new ArrayList<TicketStub>();
		try {
			List<Ticket> tickets = null;
			/*
			if (criteria.getSystem() == null) {
				tickets = this.service.readAll();
			} else {
				tickets = this.service.read(BCategory.valueOf(criteria.getCategory().name()));
			}
			*/
			stubs = this.converter.to(tickets);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Tickets by criteria (" + criteria + ") --> " + stubs.size() + " ticket(s)");
			}
		} catch (final /* PersistenceServiceException */ Exception e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return stubs;
	}

	@Override
	public TicketStub saveTicket(String id, String system, String sender_name, PriorityStub priority, String business_impact, String steps_to_rep, Date creationdate, Integer level, String processor, StatusStub status,Date lastchanged) throws FacadeException {
		try {
			Ticket ticket = null;
			if (this.service.exists(id)) {
				ticket = this.service.update(id, system,sender_name, Priority.valueOf(priority.name()), business_impact, steps_to_rep, creationdate, level, processor, Status.valueOf(status.name()), lastchanged);
			} else {
				ticket = this.service.create(id, system,sender_name, Priority.valueOf(priority.name()), business_impact, steps_to_rep, creationdate, level, processor, Status.valueOf(status.name()), lastchanged);
			}
			return this.converter.to(ticket);
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public void removeTicket(String id) throws FacadeException {
		try {
			this.service.delete(id);
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

}
