package hu.todomanager.client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import hu.todomanager.ejbserviceclient.TodoFacadeRemote;
import hu.todomanager.ejbserviceclient.domain.*;
import hu.todomanager.ejbserviceclient.exception.*;

public class TodoClient {

	private static final String JBOSS_INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String JBOSS_PROVIDER_URL = "remote://localhost:4447";
	private static final String JBOSS_URL_PKG_PREFIXES = "org.jboss.ejb.client.naming";

	private static final String JBOSS_NAMING_CLIENT_EJB_CONTEXT_KEY = "jboss.naming.client.ejb.context";
	private static final String JBOSS_NAMING_CLIENT_EJB_CONTEXT_VALUE = "true";

	//private static final Logger LOGGER = Logger.getLogger(TodoClient.class);

	public static void main(String[] args){
		System.out.println(new TodoClient().invoke("TodoTest"));
	}

	private TodoStub invoke(final String name) {
		TodoStub todo = null;
		try {
			final TodoFacadeRemote facade = this.lookup();
			todo = facade.getTodoByName(name);
			//LOGGER.info(todo);
		} catch (final FacadeException e) {
			e.printStackTrace();
		} catch (final NamingException e) {
			e.printStackTrace();
		}
		return todo;
	}

	private TodoFacadeRemote lookup() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, JBOSS_INITIAL_CONTEXT_FACTORY);
		jndiProperties.put(Context.PROVIDER_URL, JBOSS_PROVIDER_URL);
		jndiProperties.put(Context.URL_PKG_PREFIXES, JBOSS_URL_PKG_PREFIXES);
		jndiProperties.put(JBOSS_NAMING_CLIENT_EJB_CONTEXT_KEY, JBOSS_NAMING_CLIENT_EJB_CONTEXT_VALUE);
		final Context context = new InitialContext(jndiProperties);
		return (TodoFacadeRemote) context.lookup("todomanager/tm-ejbservice/TodoFacadeImpl!hu.todomanager.ejbserviceclient.TodoFacadeRemote");
	}

}