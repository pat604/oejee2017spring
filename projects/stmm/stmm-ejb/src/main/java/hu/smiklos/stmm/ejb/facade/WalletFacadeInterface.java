package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.WalletStub;
import hu.smiklos.stmm.pers.entity.Wallet;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.Local;
import java.security.Principal;

/**
 * Created by SebestyenMiklos on 2017. 04. 14..
 */
@Local
public interface WalletFacadeInterface {
    WalletStub addCredit(int credit, Principal principal) throws PersistenceServiceException;
    WalletStub withdrawCredit(int credit, Principal principal) throws PersistenceServiceException;
    WalletStub getPrincipalWalletStub(Principal principal) throws PersistenceServiceException;
    Wallet getPrincipalWallet(Principal principal) throws PersistenceServiceException;
}
