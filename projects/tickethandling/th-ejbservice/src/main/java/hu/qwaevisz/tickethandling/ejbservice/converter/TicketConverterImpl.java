package hu.qwaevisz.tickethandling.ejbservice.converter;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import hu.qwaevisz.tickethandling.ejbserviceclient.domain.EmployeeStub;
import hu.qwaevisz.tickethandling.ejbserviceclient.domain.MessageStub;
import hu.qwaevisz.tickethandling.ejbserviceclient.domain.PriorityStub;
import hu.qwaevisz.tickethandling.ejbserviceclient.domain.StatusStub;
import hu.qwaevisz.tickethandling.ejbserviceclient.domain.TicketStub;
import hu.qwaevisz.tickethandling.persistence.entity.Ticket;
import hu.qwaevisz.tickethandling.persistence.service.MessageService;

@PermitAll
@Stateless
public class TicketConverterImpl implements TicketConverter {

	@EJB
	private MessageService msgService;

	@EJB
	private EmployeeConverter empConv;

	@EJB
	private SystemConverter sysConv;

	@EJB
	private MessageConverter msgConv;

	@Override
	public TicketStub to(Ticket ticket) throws DOMException, ParserConfigurationException, SAXException, IOException, ParseException {

		final StatusStub status = StatusStub.valueOf(ticket.getStatus().toString());
		final PriorityStub priority = PriorityStub.valueOf(ticket.getPriority().toString());

		EmployeeStub processor = this.empConv.to(ticket.getProcessor());
		List<MessageStub> conversation = this.msgConv.to(this.msgService.readConversation(ticket.getId()));

		return new TicketStub(ticket.getId(), this.sysConv.to(ticket.getSystem()), ticket.getSender_name(), priority, ticket.getBusiness_impact(),
				ticket.getSteps_to_rep(), ticket.getCreationdate(), ticket.getLevel(), processor, status, ticket.getLastchanged(), conversation);
	}

	@Override
	public List<TicketStub> to(List<Ticket> tickets) throws DOMException, ParserConfigurationException, SAXException, IOException, ParseException {
		final List<TicketStub> result = new ArrayList<TicketStub>();
		for (final Ticket ticket : tickets) {
			result.add(this.to(ticket));
		}
		return result;
	}

}
