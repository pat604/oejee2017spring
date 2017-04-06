package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.converter.AppUserConverterInterface;
import hu.smiklos.stmm.ejb.domain.AppUserStub;
import hu.smiklos.stmm.ejb.exception.FacadeException;
import hu.smiklos.stmm.pers.entity.AppUser;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.service.AppUserServiceInterface;
import hu.smiklos.stmm.pers.service.RegistrationPerDayService;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
@PermitAll
@Stateless(mappedName = "ejb/AppuserFacede")
public class AppUserFacade implements AppUserFacadeInterface {

    @EJB
    private AppUserServiceInterface userService;

    @EJB
    private AppUserConverterInterface converter;

    @Override
    public AppUserStub getAppUser(String userId) throws FacadeException, PersistenceServiceException {

        AppUserStub user;
        user = converter.toAppUserStub(userService.read("2017-03-12-0000001"));
        return user;
    }

    @Override
    public List<AppUserStub> getAllAppUser() throws FacadeException, PersistenceServiceException {

        List<AppUserStub> userList = new ArrayList<AppUserStub>();
        List<AppUser> users = userService.readAll();
        for (AppUser user : users){
            userList.add(converter.toAppUserStub(user));
        }
        return userList;
    }
}
