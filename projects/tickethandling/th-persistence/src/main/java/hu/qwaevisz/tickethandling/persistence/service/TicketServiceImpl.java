package hu.qwaevisz.tickethandling.persistence.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
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

@Stateless(mappedName = "ejb/ticketService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TicketServiceImpl implements TicketService {

	private static final Logger LOGGER = Logger.getLogger(TicketServiceImpl.class);

	@PersistenceContext(unitName = "th-persistence-unit")
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@EJB
	private CustomerService customerService;

	@EJB
	private EmployeeService employeeService;

	@Override
	public boolean exists(String id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Check Ticket by ID (" + id + ")");
		}
		try {
			final Long result = this.entityManager.createNamedQuery(TicketQuery.COUNT_BY_ID, Long.class).setParameter(TicketParameter.ID, id).getSingleResult();
			return result != 0;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error getting Ticket by ID (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public Ticket create(String id, String system_id, String sender_name, Priority priority, String business_impact, String steps_to_rep, Date creationdate,
			Integer level, String processor_id, Status status, Date lastchanged) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Create Ticket with id (" + id + ")");
		}
		try {
			final Ticket ticket = new Ticket(id, this.customerService.read(system_id), sender_name, priority, business_impact, steps_to_rep, creationdate,
					level, this.employeeService.read(processor_id), status, lastchanged);
			this.entityManager.persist(ticket);
			return ticket;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting Ticket with id (" + id + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public Ticket read(String id) throws PersistenceServiceException {
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
	public List<Ticket> readBySystem(String system) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Ticket by system (" + system + ")");
		}
		List<Ticket> result = null;
		try {
			result = this.entityManager.createNamedQuery(TicketQuery.GET_BY_SYSTEM, Ticket.class).setParameter(TicketParameter.SYSTEM, system).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Tickets by system! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Ticket> readByPriority(Priority priority) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Tickets by priority (" + priority + ")");
		}
		List<Ticket> result = null;
		try {
			result = this.entityManager.createNamedQuery(TicketQuery.GET_BY_PRIORITY, Ticket.class).setParameter(TicketParameter.PRIORITY, priority)
					.getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Tickets by priority! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Ticket> readByStatus(Status status) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Tickets by status (" + status + ")");
		}
		List<Ticket> result = null;
		try {
			result = this.entityManager.createNamedQuery(TicketQuery.GET_BY_STATUS, Ticket.class).setParameter(TicketParameter.STATUS, status).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Tickets by status! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public List<Ticket> readByPriorityAndStatus(Priority priority, Status status) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get Tickets by priority & status (" + priority + ", " + status + ")");
		}
		List<Ticket> result = null;
		try {
			result = this.entityManager.createNamedQuery(TicketQuery.GET_BY_PRIORITY_AND_STATUS, Ticket.class).setParameter(TicketParameter.STATUS, status)
					.setParameter(TicketParameter.PRIORITY, priority).getResultList();
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when fetching Tickets by priority and status! " + e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	public Ticket update(String id, String system_id, String sender_name, Priority priority, String business_impact, String steps_to_rep, Date creationdate,
			Integer level, String processor_id, Status status, Date lastchanged) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Update Ticket");
		}
		try {
			final Ticket ticket = this.read(id);
			ticket.setId(id);
			ticket.setSystem(this.customerService.read(system_id));
			ticket.setSender_name(sender_name);
			ticket.setPriority(priority);
			ticket.setBusiness_impact(business_impact);
			ticket.setSteps_to_rep(steps_to_rep);
			ticket.setCreationdate(creationdate);
			ticket.setProcessor(this.employeeService.read(processor_id));
			ticket.setLastchanged(lastchanged);
			ticket.setLevel(level);
			ticket.setStatus(status);

			return ticket;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error when merging Ticket! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public void delete(String id) throws PersistenceServiceException {
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
