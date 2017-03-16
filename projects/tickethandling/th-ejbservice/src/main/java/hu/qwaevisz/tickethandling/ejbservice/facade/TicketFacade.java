package hu.qwaevisz.tickethandling.ejbservice.facade;

import java.sql.Date;
import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.tickethandling.ejbservice.domain.PriorityStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.StatusStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketCriteria;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub;
import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;

@Local
public interface TicketFacade {

	TicketStub getTicket(Long id) throws FacadeException;

	List<TicketStub> getTickets(TicketCriteria criteria) throws FacadeException;

	TicketStub saveTicket(Long id, String system, String sender_name, PriorityStub priority, String business_impact, String steps_to_rep, Date creationdate, Integer level, String processor, StatusStub status, Date lastchanged) throws FacadeException;

	void removeTicket(Long id) throws FacadeException;

}
