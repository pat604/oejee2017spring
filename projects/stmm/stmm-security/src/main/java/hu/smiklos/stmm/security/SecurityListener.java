package hu.smiklos.stmm.security;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.URL;

/**
 * Created by SebestyenMiklos on 2017. 04. 05..
 */
public class SecurityListener implements ServletContextListener {
    public SecurityListener() {

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if(System.getProperty("java.security.auth.login.config") == null) {
            String jaasConfigFile = null;
            URL jaasConfigURL = this.getClass().getClassLoader().getResource("login.conf");
            if(jaasConfigURL != null) {
                jaasConfigFile = jaasConfigURL.getFile();
            }
            System.setProperty("java.security.auth.login.config", jaasConfigFile);
        }
    }
}
