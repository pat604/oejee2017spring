package hu.qwaevisz.tickethandling.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub;
import hu.qwaevisz.tickethandling.persistence.entity.Ticket;

@Local
public interface TicketConverter {

	TicketStub to(Ticket ticket);

	List<TicketStub> to(List<Ticket> tickets);

}
