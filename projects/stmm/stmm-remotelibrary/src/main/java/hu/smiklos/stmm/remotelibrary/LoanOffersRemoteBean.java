package hu.smiklos.stmm.remotelibrary;

import javax.ejb.Remote;

import hu.smiklos.stmm.remotelibrary.entity.LoanOfferRemote;
import hu.smiklos.stmm.remotelibrary.exception.ServiceException;

@Remote
public interface LoanOffersRemoteBean {

	LoanOfferRemote[] getOffers(String repayment_type, String durationFrom, String durationTo) throws ServiceException ;

}
