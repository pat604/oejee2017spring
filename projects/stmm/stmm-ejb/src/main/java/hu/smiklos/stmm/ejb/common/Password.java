package hu.smiklos.stmm.ejb.common;
import javax.ejb.Stateless;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by SebestyenMiklos on 2017. 04. 02..
 */
@Stateless
public class Password implements PasswordInderface {

    final private static String hashAndSaltSeparator = "+";


    private String password;

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
}
