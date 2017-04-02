package hu.smiklos.stmm.ejb.common;
import org.mindrot.jbcrypt.BCrypt;
import javax.ejb.Local;

/**
 * Created by SebestyenMiklos on 2017. 04. 02..
 */
@Local
public interface PasswordInterface {

    String getHashedPassword();
    boolean checkPassword(String password, String hashedPassword);
    void setPlainTextPassword(String plain_text);
}
