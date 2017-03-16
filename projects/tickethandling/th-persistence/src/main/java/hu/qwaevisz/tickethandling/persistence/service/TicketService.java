package hu.qwaevisz.tickethandling.persistence.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.tickethandling.persistence.entity.Ticket;
import hu.qwaevisz.tickethandling.persistence.entity.trunk.Status;
import hu.qwaevisz.tickethandling.persistence.entity.trunk.Priority;
import hu.qwaevisz.tickethandling.persistence.exception.PersistenceServiceException;

@Local
public interface TicketService {

	boolean exists(String id) throws PersistenceServiceException;

	Ticket create(String id, String system, String sender_name, Priority priority, String business_impact, String steps_to_rep, Date creationdate, Integer level, String processor, Status status, Date lastchanged) throws PersistenceServiceException;

	Ticket read(String id) throws PersistenceServiceException;
	
	List<Ticket> readBySystem(String system) throws PersistenceServiceException;
	
	List<Ticket> readAll() throws PersistenceServiceException;

	Ticket update(String id, String system, String sender_name, Priority priority, String business_impact, String steps_to_rep, Date creationdate, Integer level, String processor, Status status, Date lastchanged) throws PersistenceServiceException;

	void delete(String id) throws PersistenceServiceException;

}
