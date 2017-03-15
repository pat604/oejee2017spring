package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.AppUserStub;
import hu.smiklos.stmm.ejb.exception.FacadeException;
import hu.smiklos.stmm.pers.entity.AppUser;

import javax.ejb.Local;

/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
@Local
public interface AppUserFacadeInterface {

    public AppUserStub getAppUser(String userId) throws FacadeException;
}
