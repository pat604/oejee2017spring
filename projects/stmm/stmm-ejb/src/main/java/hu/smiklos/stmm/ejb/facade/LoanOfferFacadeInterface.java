package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.LoanOfferStub;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.Local;

/**
 * Created by SebestyenMiklos on 2017. 04. 18..
 */
@Local
public interface LoanOfferFacadeInterface {

    LoanOfferStub checkOffer(String moneyTtransferId) throws PersistenceServiceException;

    void acceptOffer(LoanOfferStub offerStub, String moneyTtransferId);

}
