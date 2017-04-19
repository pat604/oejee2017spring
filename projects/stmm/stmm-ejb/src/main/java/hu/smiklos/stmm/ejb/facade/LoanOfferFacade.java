package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.LoanOfferStub;
import hu.smiklos.stmm.ejb.domain.MoneyTransferStub;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by SebestyenMiklos on 2017. 04. 18..
 */
@PermitAll
@Stateless(mappedName = "ejb/LoanOfferFacade")
public class LoanOfferFacade implements LoanOfferFacadeInterface {

    @EJB
    private MoneyTransferFacadeInterface mTransferFacade;


    @Override
    public LoanOfferStub checkOffer(String moneyTtransferId) throws PersistenceServiceException {
        MoneyTransferStub mTransferStub = mTransferFacade.getPreparedMoneyTransferStub(moneyTtransferId);
        LoanOfferStub offer= new LoanOfferStub(mTransferStub.toMoneyTransfer());
        return offer;
    }

    @Override
    public void acceptOffer(LoanOfferStub offerStub, String moneyTtransferId) {

    }
}
