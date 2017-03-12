package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.AppUserStub;
import hu.smiklos.stmm.ejb.exception.FacadeException;

import javax.ejb.Stateless;

/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
@Stateless
public class AppUserFacade implements AppUserFacadeInterface {


    public AppUserStub getAppUser(String userId) throws FacadeException {
        AppUserStub user = new AppUserStub(userId,"EMEA-HU-00000001");
        return user;
    }
}
