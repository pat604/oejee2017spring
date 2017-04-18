package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.web.common.AcceptLoanOfferAttributes;
import hu.smiklos.stmm.web.common.Page;

import javax.annotation.security.PermitAll;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by SebestyenMiklos on 2017. 04. 18..
 */
@PermitAll
@WebServlet("/AcceptLoanOffer")
public class AcceptLoanOfferServlet extends BaseServlet {



    @Override
    public void handleGet() throws ServletException, IOException, PersistenceServiceException {
        request.getParameter(AcceptLoanOfferAttributes.LOAN_OFFER_MONEY_TRANSFER_ID);

        forward(Page.ACCEPT_LOAN_OFFER.getJspName());
    }

    @Override
    public void handlePost() throws ServletException, IOException, PersistenceServiceException {
        forward(Page.ACCEPT_LOAN_OFFER.getJspName());
    }

}
