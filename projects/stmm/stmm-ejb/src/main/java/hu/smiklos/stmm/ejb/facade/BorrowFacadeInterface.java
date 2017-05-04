package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.BorrowStub;
import hu.smiklos.stmm.ejb.domain.OfferListOnBorrowQuery;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.remotelibrary.entity.LoanOfferRemote;
import hu.smiklos.stmm.remotelibrary.exception.ServiceException;

import javax.ejb.Local;
import java.security.Principal;

/**
 * Created by SebestyenMiklos on 2017. 04. 16..
 */
@Local
public interface BorrowFacadeInterface {

        OfferListOnBorrowQuery getOffers(BorrowStub borrow_filter, Principal principal) throws PersistenceServiceException;

        OfferListOnBorrowQuery getOffers(String repayment_type);

        LoanOfferRemote[] getOffers(String repayment_type, String durationFrom, String durationTo) throws ServiceException;

}
