package hu.smiklos.stmm.security;

import hu.smiklos.stmm.ejb.common.Password;
import hu.smiklos.stmm.ejb.common.PasswordCheckInterface;
import org.jboss.security.auth.spi.DatabaseServerLoginModule;

/**
 * Created by SebestyenMiklos on 2017. 04. 05..
 */
public class StmmLoginModule extends DatabaseServerLoginModule {

    PasswordCheckInterface pwService;

    @Override
    protected boolean validatePassword(String inputPassword, String expectedPassword) {
        String iPw = inputPassword;
        String expPw = expectedPassword;
        boolean iValid = getPasswordService().checkPassword(iPw,expPw);
        return iValid;
    }

    public PasswordCheckInterface getPasswordService() {
        if(pwService == null){
            pwService = new Password();
        }
        return pwService;
    }

}
