package hu.smiklos.stmm.ejb.common;
import org.mindrot.jbcrypt.BCrypt;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;

/**
 * Created by SebestyenMiklos on 2017. 04. 02..
 */
@PermitAll
@Stateless(mappedName = "ejb/Password")
public class Password implements PasswordInterface {

    private String password;

    public Password() {
    }

    public Password(String password) {
        this.password = password;
    }

    @Override
    public String getHashedPassword() {
        String salt =  BCrypt.gensalt();
        String hashed = BCrypt.hashpw(password, salt);
        return hashed;
    }

    @Override
    public boolean checkPassword(String password, String hashedPassword) {
        boolean checkPassword = BCrypt.checkpw(password,hashedPassword);
        return checkPassword;
    }

    @Override
    public void setPlainTextPassword(String plain_text) {
        this.password = plain_text;
    }
}
