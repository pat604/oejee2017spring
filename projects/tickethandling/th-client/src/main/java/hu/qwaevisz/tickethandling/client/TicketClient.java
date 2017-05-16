package hu.qwaevisz.tickethandling.client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import hu.qwaevisz.tickethandling.ejbserviceclient.TicketFacadeRemote;
import hu.qwaevisz.tickethandling.ejbserviceclient.domain.MessageStub;
import hu.qwaevisz.tickethandling.ejbserviceclient.domain.TicketStub;
import hu.qwaevisz.tickethandling.ejbserviceclient.exception.ServiceException;

public class TicketClient {

	private static final String JBOSS_INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String JBOSS_PROVIDER_URL = "remote://localhost:4447";
	private static final String JBOSS_URL_PKG_PREFIXES = "org.jboss.ejb.client.naming";

	private static final String JBOSS_NAMING_CLIENT_EJB_CONTEXT_KEY = "jboss.naming.client.ejb.context";
	private static final String JBOSS_NAMING_CLIENT_EJB_CONTEXT_VALUE = "true";

	private static final Logger LOGGER = Logger.getLogger(TicketClient.class);

	public static void main(final String[] args) throws Exception {
		TicketStub ticket = new TicketClient().invoke("RTS75820170318051534");

		for (MessageStub msg : ticket.getConversation()) {
			System.out.println(msg);
		}
	}

	private TicketStub invoke(final String id) {
		TicketStub ticket = null;
		try {
			final TicketFacadeRemote facade = this.lookup();
			ticket = facade.getTicket(id);

			System.out.println("GOT THE TICKET");

		} catch (final ServiceException e) {
			e.printStackTrace();
		} catch (final NamingException e) {
			e.printStackTrace();
		}
		return ticket;
	}

	private TicketFacadeRemote lookup() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, JBOSS_INITIAL_CONTEXT_FACTORY);
		jndiProperties.put(Context.PROVIDER_URL, JBOSS_PROVIDER_URL);
		jndiProperties.put(Context.URL_PKG_PREFIXES, JBOSS_URL_PKG_PREFIXES);
		jndiProperties.put(JBOSS_NAMING_CLIENT_EJB_CONTEXT_KEY, JBOSS_NAMING_CLIENT_EJB_CONTEXT_VALUE);
		final Context context = new InitialContext(jndiProperties);
		return (TicketFacadeRemote) context
				.lookup("tickethandling/th-ejbservice/TicketFacadeImpl!hu.qwaevisz.tickethandling.ejbserviceclient.TicketFacadeRemote");
	}
}