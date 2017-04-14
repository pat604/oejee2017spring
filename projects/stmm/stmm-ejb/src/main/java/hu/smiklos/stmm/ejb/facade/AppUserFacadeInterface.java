package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.AppUserStub;
import hu.smiklos.stmm.ejb.domain.WalletStub;
import hu.smiklos.stmm.ejb.exception.FacadeException;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.Local;
import java.security.Principal;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 03. 12..
 */
@Local
public interface AppUserFacadeInterface {

     AppUserStub getAppUser(String userId) throws FacadeException, PersistenceServiceException;

     List<AppUserStub> getAllAppUser() throws FacadeException, PersistenceServiceException;

     WalletStub getWallet(Principal userPrincipal) throws PersistenceServiceException;
}
