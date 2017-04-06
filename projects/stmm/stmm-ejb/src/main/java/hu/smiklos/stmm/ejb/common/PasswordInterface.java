package hu.smiklos.stmm.ejb.common;
import javax.ejb.Local;

/**
 * Created by SebestyenMiklos on 2017. 04. 02..
 */
@Local
public interface PasswordInterface {

    String getHashedPassword(String plain_text_password);
    boolean checkPassword(String password, String hashedPassword);
    void setPlainTextPassword(String plain_text);
}
