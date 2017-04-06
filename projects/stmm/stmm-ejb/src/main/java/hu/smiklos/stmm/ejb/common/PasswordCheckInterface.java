package hu.smiklos.stmm.ejb.common;

import javax.ejb.Local;

/**
 * Created by SebestyenMiklos on 2017. 04. 05..
 */
@Local
public interface PasswordCheckInterface {
    boolean checkPassword(String password, String hashedPassword);
}
