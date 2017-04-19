package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.MoneyTransferStub;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.Local;
import java.security.Principal;

/**
 * Created by SebestyenMiklos on 2017. 04. 15..
 */
@Local
public interface MoneyTransferFacadeInterface {

    void create(MoneyTransferStub mtStub, Principal principal) throws PersistenceServiceException;

    MoneyTransferStub getPreparedMoneyTransferStub(Principal principal) throws PersistenceServiceException;

    MoneyTransferStub getPreparedMoneyTransferStub(String moneyTtransferId) throws PersistenceServiceException;
}
