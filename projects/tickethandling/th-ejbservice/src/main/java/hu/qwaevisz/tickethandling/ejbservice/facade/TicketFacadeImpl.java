
package hu.qwaevisz.tickethandling.ejbservice.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

			//
			// No criteria
			//
			if (criteria.getPriority() == null && criteria.getStatus() == null) {
				tickets = this.service.readAll();

			} else {
				if (criteria.getPriority() != null && criteria.getStatus() != null) {
					//
					// Double criteria
					//
					tickets = this.service.readByPriorityAndStatus(Priority.valueOf(criteria.getPriority().name()),
							Status.valueOf(criteria.getStatus().name()));

				} else {
					if (criteria.getStatus() == null) {
						//
						// Searched by PRIORITY
						//
						tickets = this.service.readByPriority(Priority.valueOf(criteria.getPriority().name()));
					} else {
						//
						// Searched by STATUS
						//
						tickets = this.service.readByStatus(Status.valueOf(criteria.getStatus().name()));
					}
				}
			}

			stubs = this.converter.to(tickets);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Tickets by criteria (" + criteria + ") --> " + stubs.size() + " ticket(s)");
			}
		} catch (final PersistenceServiceException e) {
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
			List<SystemStub> stubs = this.custConverter.to(this.custService.readAll());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Get Systems");
			}
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
