package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.AppUser;
import hu.smiklos.stmm.pers.entity.CreditCard;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.Local;
import java.security.Principal;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 03. 16..
 */
@Local
public interface AppUserServiceInterface {


    List<AppUser> readAll() throws PersistenceServiceException;

    AppUser read(String appuserId) throws PersistenceServiceException;

    AppUser create(AppUser user) throws PersistenceServiceException;

    AppUser getUserByUsername(String username) throws PersistenceServiceException;

    CreditCard addCreditCard(CreditCard card, Principal principal) throws PersistenceServiceException;

    CreditCard updateCreditCard(CreditCard card, Principal principal) throws PersistenceServiceException;

    void deleteCreditCard(Principal principal) throws PersistenceServiceException;

}
