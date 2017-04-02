package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.converter.UserRegisterStubToUserInterface;
import hu.smiklos.stmm.ejb.domain.UserRegistrationStub;
import hu.smiklos.stmm.pers.entity.AppUser;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.service.AppUserServiceInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by SebestyenMiklos on 2017. 03. 30..
 */
@Stateless
public class UserRegistrationFacade implements UserRegistrationFacadeInterface {

    @EJB
    private AppUserServiceInterface service;

    @EJB
    private UserRegisterStubToUserInterface converter;

    private UserRegistrationStub userRegistrationStub;

    @Override
    public UserRegistrationStub getUserRegistrationStub() {
        if(userRegistrationStub == null){
            userRegistrationStub = new UserRegistrationStub();
        }
        return userRegistrationStub;
    }

    @Override
    public void createUser(UserRegistrationStub stub) throws PersistenceServiceException {
        AppUser user= converter.formToAppUser(stub);
        service.create(user);
    }

}
