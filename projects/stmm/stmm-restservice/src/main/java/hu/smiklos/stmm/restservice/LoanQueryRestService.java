package hu.smiklos.stmm.restservice;

import hu.smiklos.stmm.ejb.domain.OfferListOnBorrowQuery;
import hu.smiklos.stmm.ejb.facade.BorrowFacadeInterface;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by SebestyenMiklos on 2017. 05. 01..
 */
@Stateless
public class LoanQueryRestService implements LoanQueryRestServiceInterface {

    @EJB
    private BorrowFacadeInterface borrowFacade;

    @Override
    public OfferListOnBorrowQuery getOffers(String repayment_type) throws PersistenceServiceException {

        OfferListOnBorrowQuery result = borrowFacade.getOffers(repayment_type);
        return result;
    }
}
