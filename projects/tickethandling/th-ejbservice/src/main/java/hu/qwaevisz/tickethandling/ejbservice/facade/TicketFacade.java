package hu.qwaevisz.tickethandling.ejbservice.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.tickethandling.ejbservice.domain.EmployeeStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.PriorityStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.StatusStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.SystemStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketCriteria;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub;
import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;

@Local
public interface TicketFacade {

	TicketStub getTicket(String id) throws FacadeException;

	List<TicketStub> getTickets(TicketCriteria criteria) throws FacadeException;

	TicketStub saveTicket(String id, SystemStub system, String sender_name, PriorityStub priority, String business_impact, String steps_to_rep,
			Date creationdate, Integer level, EmployeeStub processor, StatusStub status, Date lastchanged) throws FacadeException;

	void removeTicket(String id) throws FacadeException;

}
