package hu.qwaevisz.tickethandling.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;

import hu.qwaevisz.tickethandling.ejbservice.domain.EmployeeStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.PriorityStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.StatusStub;
import hu.qwaevisz.tickethandling.ejbservice.domain.TicketStub;
import hu.qwaevisz.tickethandling.persistence.entity.Ticket;

@PermitAll
@Stateless
public class TicketConverterImpl implements TicketConverter {

	@Override
	public TicketStub to(Ticket ticket) {
		final EmployeeConverter empConv = new EmployeeConverterImpl();
		final CustomerConverter custConv = new CustomerConverterImpl();

		final StatusStub status = StatusStub.valueOf(ticket.getStatus().toString());
		final PriorityStub priority = PriorityStub.valueOf(ticket.getPriority().toString());

		EmployeeStub processor = null;
		if (ticket.getProcessor() != null) {
			processor = empConv.to(ticket.getProcessor());
		}

		return new TicketStub(ticket.getId(), custConv.to(ticket.getSystem()), ticket.getSender_name(), priority, ticket.getBusiness_impact(),
				ticket.getSteps_to_rep(), ticket.getCreationdate(), ticket.getLevel(), processor, status, ticket.getLastchanged());
	}

	@Override
	public List<TicketStub> to(List<Ticket> tickets) {
		final List<TicketStub> result = new ArrayList<TicketStub>();
		for (final Ticket ticket : tickets) {
			result.add(this.to(ticket));
		}
		return result;
	}

}
