package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.BorrowStub;
import hu.smiklos.stmm.ejb.domain.OfferListOnBorrowQuery;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.Local;

/**
 * Created by SebestyenMiklos on 2017. 04. 16..
 */
@Local
public interface BorrowFacadeInterface {

        OfferListOnBorrowQuery getOffers(BorrowStub borrow_filter) throws PersistenceServiceException;

        OfferListOnBorrowQuery getAllOffers();

        OfferListOnBorrowQuery getAllOnPlateOffers();
}
