package hu.smiklos.stmm.remoteclient;

import org.apache.log4j.Logger;


import javax.security.auth.callback.*;
import javax.security.sasl.RealmCallback;
import java.io.IOException;

/**
 * Created by SebestyenMiklos on 2017. 05. 04..
 */
public class RemoteLoginCallbackHandler implements CallbackHandler {
    private static final Logger LOGGER = Logger.getLogger(RemoteLoginCallbackHandler.class);

    private static String s_username;
    private static String s_password;

    public static void setCredential(String username, String password) {

        synchronized (RemoteLoginCallbackHandler.class) {
            s_username = username;
            s_password = password;
        }
    }

    public RemoteLoginCallbackHandler() {

    }


    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        synchronized (RemoteLoginCallbackHandler.class) {
            LOGGER.info("My callback handler");
            for (Callback current : callbacks) {
                if (current instanceof RealmCallback) {
                    RealmCallback rcb = (RealmCallback) current;
                    String defaultText = rcb.getDefaultText();
                    rcb.setText(defaultText);
                } else if (current instanceof NameCallback) {
                    NameCallback ncb = (NameCallback) current;
                    ncb.setName(s_username);
                } else if (current instanceof PasswordCallback) {
                    PasswordCallback pcb = (PasswordCallback) current;
                    pcb.setPassword(s_password.toCharArray());
                } else {
                    throw new UnsupportedCallbackException(current);
                }
            }
        }
    }
}
