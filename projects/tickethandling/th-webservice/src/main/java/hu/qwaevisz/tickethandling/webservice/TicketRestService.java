package hu.qwaevisz.tickethandling.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import hu.qwaevisz.tickethandling.ejbservice.exception.AdaptorException;
import hu.qwaevisz.tickethandling.ejbservice.exception.FacadeException;
import hu.qwaevisz.tickethandling.ejbserviceclient.domain.TicketStub;
import hu.qwaevisz.tickethandling.ejbserviceclient.exception.ServiceException;
import hu.qwaevisz.tickethandling.webservice.domain.MessageCreateRemoteStub;
import hu.qwaevisz.tickethandling.webservice.domain.TicketCreateRemoteStub;

@Path("/ticket")
public interface TicketRestService {

	@GET
	@Path("/all")
	@Produces("application/json")
	List<TicketStub> getTickets() throws AdaptorException, FacadeException;

	@GET
	@Path("/system/{systemid}")
	@Produces("application/json")
	List<TicketStub> getTickets(@PathParam("systemid") String systemid) throws AdaptorException, FacadeException;

	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	TicketStub createTicket(TicketCreateRemoteStub ticket) throws AdaptorException, FacadeException;

	@POST
	@Path("/send")
	@Consumes("application/json")
	boolean sendMessage(MessageCreateRemoteStub message) throws AdaptorException, FacadeException, ServiceException;
}
