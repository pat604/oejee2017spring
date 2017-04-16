package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.Wallet;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.Local;
import java.security.Principal;

/**
 * Created by SebestyenMiklos on 2017. 04. 14..
 */
@Local
public interface WalletServiceInterface {

    Wallet read(String walletId) throws PersistenceServiceException;

    Wallet getAppUserWallet(Principal principal) throws  PersistenceServiceException;
}
