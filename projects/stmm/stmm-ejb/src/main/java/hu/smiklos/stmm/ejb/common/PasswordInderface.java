package hu.smiklos.stmm.ejb.common;

import javax.ejb.Local;

/**
 * Created by SebestyenMiklos on 2017. 04. 02..
 */
@Local
public interface PasswordInderface {

    String getHashedPassword();
    boolean checkPassword(String password, String hashedPassword);
}
