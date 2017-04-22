
package hu.qwaevisz.tickethandling.ejbservice.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.qwaevisz.tickethandling.ejbservice.converter.CustomerConverter;
import hu.qwaevisz.tickethandling.ejbservice.converter.EmployeeConverter;
import hu.qwaevisz.tickethandling.ejbservice.converter.TicketConverter;
import hu.qwaevisz.tickethandling.ejbservice.domain.EmployeeStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.PriorityStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.StatusStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.SystemStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketCriteria;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub;
import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;
import hu.qwaevisz.tickethandling.persistence.entity.Ticket;
import hu.qwaevisz.tickethandling.persistence.entity.trunk.Priority;
import hu.qwaevisz.tickethandling.persistence.entity.trunk.Status;
import hu.qwaevisz.tickethandling.persistence.exception.PersistenceServiceException;
import hu.qwaevisz.tickethandling.persistence.service.CustomerService;
import hu.qwaevisz.tickethandling.persistence.service.EmployeeService;
import hu.qwaevisz.tickethandling.persistence.service.TicketService;

@PermitAll
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
			List<Ticket> tickets = this.service.readAll();
			List<Ticket> filtered = new ArrayList<Ticket>(tickets);

			for (Ticket ticket : tickets) {

				if (criteria.getId() != null && criteria.getId() != ticket.getId()) {
					filtered.remove(ticket);
					continue;
				}

				if (criteria.getPriority() != null && criteria.getPriority().toString() != ticket.getPriority().toString()) {
					filtered.remove(ticket);
					continue;
				}

				if (criteria.getStatus() != null && criteria.getStatus().toString() != ticket.getStatus().toString()) {
					filtered.remove(ticket);
					continue;
				}

				if (criteria.getProcessorId() != null && (ticket.getProcessor() == null || !criteria.getProcessorId().equals(ticket.getProcessor().getId()))) {
					filtered.remove(ticket);
					continue;
				}

				if (criteria.getSystem() != null && criteria.getSystem() != ticket.getSystem().getId()) {
					filtered.remove(ticket);
					continue;
				}

				if (criteria.getLevel() != null && criteria.getLevel() != ticket.getLevel()) {
					filtered.remove(ticket);
					continue;
				}
			}

			stubs = this.converter.to(filtered);

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Tickets by criteria (" + criteria + ") --> " + stubs.size() + " ticket(s)");
			}
		} catch (

		final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
		return stubs;
	}

	@Override
	public TicketStub saveTicket(String id, SystemStub system, String sender_name, PriorityStub priority, String business_impact, String steps_to_rep,
			Date creationdate, Integer level, EmployeeStub processor, StatusStub status, Date lastchanged) throws FacadeException {
		try {
			Ticket ticket = null;
			if (this.service.exists(id)) {
				ticket = this.service.update(id, system.getId(), sender_name, Priority.valueOf(priority.name()), business_impact, steps_to_rep, creationdate,
						level, processor.getId(), Status.valueOf(status.name()), lastchanged);
			} else {
				ticket = this.service.create(id, system.getId(), sender_name, Priority.valueOf(priority.name()), business_impact, steps_to_rep, creationdate,
						level, processor.getId(), Status.valueOf(status.name()), lastchanged);
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

	//
	// Place to another file later
	//

	@EJB
	private CustomerService custService;

	@EJB
	private CustomerConverter custConverter;

	@EJB
	private EmployeeService empService;

	@EJB
	private EmployeeConverter empConverter;

	@Override
	public SystemStub getSystem(String id) throws FacadeException {
		try {
			final SystemStub stub = this.custConverter.to(this.custService.read(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get System by id (" + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public List<SystemStub> getSystems() throws FacadeException {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Systems");
			}
			List<SystemStub> stubs = this.custConverter.to(this.custService.readAll());
			return stubs;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public EmployeeStub getEmployee(String id) throws FacadeException {
		try {
			final EmployeeStub stub = this.empConverter.to(this.empService.read(id));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Employee by id (" + id + ") --> " + stub);
			}
			return stub;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	@Override
	public List<EmployeeStub> getEmployees() throws FacadeException {
		try {
			List<EmployeeStub> stubs = this.empConverter.to(this.empService.readAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Employees");
			}
			return stubs;
		} catch (final PersistenceServiceException e) {
			LOGGER.error(e, e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
}
