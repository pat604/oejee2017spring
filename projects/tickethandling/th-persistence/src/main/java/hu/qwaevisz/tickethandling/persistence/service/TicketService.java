package hu.qwaevisz.tickethandling.persistence.service;

import java.sql.Date;
import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.tickethandling.persistence.entity.Ticket;
import hu.qwaevisz.tickethandling.persistence.entity.trunk.Status;
import hu.qwaevisz.tickethandling.persistence.entity.trunk.Priority;
import hu.qwaevisz.tickethandling.persistence.exception.PersistenceServiceException;

@Local
public interface TicketService {

	boolean exists(Long id) throws PersistenceServiceException;

	Ticket create(String system, String sender_name, Priority priority, String business_impact, String steps_to_rep, Date creationdate, Integer level, String processor, Status status, Date lastchanged) throws PersistenceServiceException;

	Ticket read(Long id) throws PersistenceServiceException;

	List<Ticket> readAll() throws PersistenceServiceException;

	List<Ticket> read(Status status) throws PersistenceServiceException;
	
	List<Ticket> read(Priority priority) throws PersistenceServiceException;

	Ticket update(String system, String sender_name, Priority priority, String business_impact, String steps_to_rep, Date creationdate, Integer level, String processor, Status status, Date lastchanged) throws PersistenceServiceException;

	void delete(Long id) throws PersistenceServiceException;

}
