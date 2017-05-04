package hu.smiklos.stmm.remoteclient;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.Properties;

/**
 * Created by SebestyenMiklos on 2017. 05. 04..
 */
public class TestClient {

    private static final String JBOSS_INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    private static final String JBOSS_PROVIDER_URL = "remote://localhost:4447";
    private static final String JBOSS_URL_PKG_PREFIXES = "org.jboss.ejb.client.naming";

    private static final String JBOSS_NAMING_CLIENT_EJB_CONTEXT_KEY = "jboss.naming.client.ejb.context";
    private static final String JBOSS_NAMING_CLIENT_EJB_CONTEXT_VALUE = "true";

    private static final Logger LOGGER = Logger.getLogger(TestClient.class);

    public static void main(String[] args) throws NamingException {
        new TestClient().run();
    }

    public void run() throws NamingException {
        Object o = lookup();
        LOGGER.info("Remote client OK");
    }

    /**
     * Constructs the JNDI coordinates for the given EJB.
     * <p>
     * This method uses the EJB Client API coordinates (starting with
     * <code>ejb:</code>) and doesn't do any lookup - it merely provides you
     * with the JNDI coordinates.
     * </p>
     * <p>
     * The format of the EJB Client API is as follows: <br/>
     * <code>ejb:[appName]/[moduleName]/[beanName][!interfaceName][?stateful]</code>
     * </p>
     *
     * @param appName
     *            application name
     * @param moduleName
     *            the bean implementation's smodule name
     * @param beanName
     *            implemented bean name
     * @param interfaceName
     *            bean interface name with full path
     * @param isStateful
     *            is it the SFSB?
     *
     * @return JNDI coordinates
     */
    String getJNDICoordinates(String appName, String moduleName,
                              String beanName, String interfaceName, boolean isStateful) {
        String result = "ejb:" + appName + "/" + moduleName + "/" + beanName;

        if (interfaceName != null && !interfaceName.isEmpty()) {
            result += "!" + interfaceName;
        }

        if (isStateful) {
            result += "?stateful";
        }

        return result;
    }

    String getJNDICoordinates(String appName, String moduleName,
                              String beanName, String interfaceName) {
        return getJNDICoordinates(appName, moduleName, beanName, interfaceName,
                false);
    }

    String getJNDICoordinates(String appName, String moduleName, String beanName) {
        return getJNDICoordinates(appName, moduleName, beanName, "", false);
    }

    private Object lookup() throws NamingException {
        final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, JBOSS_INITIAL_CONTEXT_FACTORY);
        jndiProperties.put(Context.PROVIDER_URL, JBOSS_PROVIDER_URL);
        jndiProperties.put(Context.URL_PKG_PREFIXES, JBOSS_URL_PKG_PREFIXES);
        jndiProperties.put(JBOSS_NAMING_CLIENT_EJB_CONTEXT_KEY, JBOSS_NAMING_CLIENT_EJB_CONTEXT_VALUE);
        final Context context = new InitialContext(jndiProperties);
        return  context.lookup(getJNDICoordinates("Stmm", "stmm-ejb", "BorrowFacade",
                "hu.smiklos.stmm.remotelibrary.LoanOffersRemoteBean"));
    }
}


