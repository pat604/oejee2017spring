package hu.smiklos.stmm.remotelibrary;

import javax.ejb.Remote;
import hu.smiklos.stmm.remotelibrary.exception.ServiceException;

@Remote
public interface LoanOffersRemoteBean {

	String getOffer(String repayment_type) throws ServiceException;

}
