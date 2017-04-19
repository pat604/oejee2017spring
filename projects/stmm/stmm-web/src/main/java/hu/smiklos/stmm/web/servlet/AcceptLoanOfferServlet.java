package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.ejb.domain.LoanOfferStub;
import hu.smiklos.stmm.ejb.facade.LoanOfferFacadeInterface;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.web.common.AcceptLoanOfferAttributes;
import hu.smiklos.stmm.web.common.Page;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by SebestyenMiklos on 2017. 04. 18..
 */
@PermitAll
@WebServlet("/AcceptLoanOffer")
public class AcceptLoanOfferServlet extends BaseServlet {


    @EJB
    LoanOfferFacadeInterface offerFacade;

    @Override
    public void handleGet() throws ServletException, IOException, PersistenceServiceException {
        String offerId = request.getParameter(AcceptLoanOfferAttributes.LOAN_OFFER_MONEY_TRANSFER_ID);
        if(offerId != null && !offerId.isEmpty()){
            LoanOfferStub offerStub = offerFacade.checkOffer(offerId);
            request.setAttribute(AcceptLoanOfferAttributes.LOAN_OFFER_STUB, offerStub);
        }
        forward(Page.ACCEPT_LOAN_OFFER.getJspName());
    }

    @Override
    public void handlePost() throws ServletException, IOException, PersistenceServiceException {
        forward(Page.ACCEPT_LOAN_OFFER.getJspName());
    }

}
