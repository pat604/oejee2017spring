package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.ejb.domain.LoanOfferStub;
import hu.smiklos.stmm.ejb.facade.LoanOfferFacadeInterface;
import hu.smiklos.stmm.ejb.uribuilder.UriBuilder;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.web.common.*;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.security.Principal;

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
        String transferMoneyId = request.getParameter(AcceptLoanOfferAttributes.LOAN_OFFER_MONEY_TRANSFER_ID);
        offerFacade.acceptOffer(transferMoneyId, request.getUserPrincipal());
        response.sendRedirect(UriBuilder.getUrl(Page.BORROW.getUrl(), BorrowAttributes.LOAN_ACCEPTED));
    }



}
