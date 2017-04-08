package hu.smiklos.stmm.ejb.converter;

import hu.smiklos.stmm.ejb.domain.UserRegistrationStub;
import hu.smiklos.stmm.pers.entity.AppUser;

import javax.ejb.Local;

/**
 * Created by SebestyenMiklos on 2017. 03. 30..
 */
@Local
public interface UserRegisterStubToUserInterface {

    public AppUser formToAppUser(UserRegistrationStub stub);

}
