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
			final Ticket ticket = new Book(isbn, author, title, numberOfPages, price, category);
			this.entityManager.persist(book);
			return book;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting Book (" + isbn + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public Ticket read(Long id) throws PersistenceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Read ticket by ID (" + id + ")");
		}
		try {
			final Ticket ticket = new Book(isbn, author, title, numberOfPages, price, category);
			this.entityManager.persist(book);
			return book;
		} catch (final Exception e) {
			throw new PersistenceServiceException("Unknown error during persisting Book (" + isbn + ")! " + e.getLocalizedMessage(), e);
		}
	}

	@Override
	public List<Ticket> readAll() throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> read(Status status) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> read(Priority priority) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket update(String system, String sender_name, Priority priority, String business_impact,
			String steps_to_rep, Date creationdate, Integer level, String processor, Status status, Date lastchanged)
			throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		
	}
}
