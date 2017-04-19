package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.CreditCard;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.Local;

/**
 * Created by SebestyenMiklos on 2017. 04. 12..
 */
@Local
public interface CreditCardServiceInterface {
    CreditCard readByCreditCardId(String creditcard_id) throws PersistenceServiceException;
    void delete(String creditcard_card_number) throws PersistenceServiceException;

}
