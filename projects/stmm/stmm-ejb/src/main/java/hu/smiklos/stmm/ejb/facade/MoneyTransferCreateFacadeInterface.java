package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.MoneyTransferCreateStub;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.Local;
import java.security.Principal;

/**
 * Created by SebestyenMiklos on 2017. 04. 15..
 */
@Local
public interface MoneyTransferCreateFacadeInterface {

    void create(MoneyTransferCreateStub mtStub, Principal principal) throws PersistenceServiceException;

    MoneyTransferCreateStub getPreparedMoneyTransferStub(Principal principal) throws PersistenceServiceException;

}
