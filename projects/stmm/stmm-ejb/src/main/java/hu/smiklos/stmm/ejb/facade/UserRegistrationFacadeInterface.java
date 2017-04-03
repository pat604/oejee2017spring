package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.UserRegistrationStub;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.Local;

/**
 * Created by SebestyenMiklos on 2017. 03. 22..
 */
@Local
public interface UserRegistrationFacadeInterface {

    UserRegistrationStub getUserRegistrationStub();

    void createUser(UserRegistrationStub stub) throws PersistenceServiceException;

}
