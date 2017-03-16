package hu.qwaevisz.tickethandling.persistence.service;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.qwaevisz.tickethandling.persistence.entity.Ticket;
import hu.qwaevisz.tickethandling.persistence.entity.trunk.Priority;
import hu.qwaevisz.tickethandling.persistence.entity.trunk.Status;
import hu.qwaevisz.tickethandling.persistence.exception.PersistenceServiceException;
import hu.qwaevisz.tickethandling.persistence.parameter.TicketParameter;
import hu.qwaevisz.tickethandling.persistence.query.TicketQuery;

@Stateless(mappedName = "ejb/bookService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TicketServiceImpl implements TicketService {

	private static final Logger LOGGER = Logger.getLogger(TicketServiceImpl.class);

	@PersistenceContext(unitName = "bs-persistence-unit")
	private EntityManager entityManager;

	@Override
	public boolean exists(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Check Ticket by ID (" + id + ")");
		}
		try {
			return this.entityManager.createNamedQuery(TicketQuery.GET_BY_ID, Long.class).setParameter(TicketParameter.ID, id).getSingleResult() == 1;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error getting Ticket by ID (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public Ticket create(String system, String sender_name, Priority priority, String business_impact, String steps_to_rep, Date creationdate, Integer level, String processor, Status status, Date lastchanged) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Create Ticket for system (" + system + ")");
		}
		try {
			final Ticket ticket = new Ticket(system, sender_name, priority, business_impact, steps_to_rep, creationdate, level, processor, status, lastchanged);
			this.entityManager.persist(ticket);
			return ticket;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting Ticket for system (" + system + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public Ticket read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Ticket by id (" + id + ")");
		}
		Ticket result = null;
		try {
			result = this.entityManager.createNamedQuery(TicketQuery.GET_BY_ID, Ticket.class).setParameter(TicketParameter.ID, id).getSingleResult();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Ticket by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Ticket> readAll() throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Tickets");
		}
		List<Ticket> result = null;
		try {
			result = this.entityManager.createNamedQuery(TicketQuery.GET_ALL, Ticket.class).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Tickets! " + e.getLocalizedMessage(), e);
		}
		return result;
	}
	
	@Override
	public List<Ticket> read(String system) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Ticket by system (" + system  + ")");
		}
		List<Ticket> result = null;
		try {
			result = this.entityManager.createNamedQuery(TicketQuery.GET_BY_SYSTEM, Ticket.class).setParameter(TicketParameter.SYSTEM, system).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Tickets! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Ticket update(Long id, String system, String sender_name, Priority priority, String business_impact, String steps_to_rep, Date creationdate, Integer level, String processor, Status status, Date lastchanged) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Update Ticket");
		}
		try {
			final Ticket ticket = this.read(id);
			ticket.setSystem(system);
			ticket.setSender_name(sender_name);
			ticket.setPriority(priority);
			ticket.setBusiness_impact(business_impact);
			ticket.setSteps_to_rep(steps_to_rep);
			ticket.setCreationdate(creationdate);
			ticket.setProcessor(processor);
			ticket.setLastchanged(lastchanged);
			ticket.setLevel(level);
			ticket.setStatus(status);
			
			return ticket;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when mergning Ticket! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void delete(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Remove Ticket by id (" + id + ")");
		}
		try {
			this.entityManager.createNamedQuery(TicketQuery.REMOVE_BY_ID).setParameter(TicketParameter.ID, id).executeUpdate();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when removing Ticket by id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}
}
