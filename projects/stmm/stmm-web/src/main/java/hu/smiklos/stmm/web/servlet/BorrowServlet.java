package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.ejb.domain.BorrowStub;
import hu.smiklos.stmm.ejb.domain.OfferListOnBorrowQuery;
import hu.smiklos.stmm.ejb.facade.BorrowFacadeInterface;
import hu.smiklos.stmm.pers.entity.trunk.MoneyTransferStates;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.web.common.BorrowAttributes;
import hu.smiklos.stmm.web.common.GeneralAttributes;
import hu.smiklos.stmm.web.common.Page;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by SebestyenMiklos on 2017. 04. 06..
 */
@PermitAll
@WebServlet("/Borrow")
public class BorrowServlet extends BaseServlet {

    @EJB
    private BorrowFacadeInterface borrowFacade;

    @Override
    public void handleGet() throws ServletException, IOException {
        forward(Page.BORROW.getJspName());
    }

    @Override
    public void handlePost() throws ServletException, IOException, PersistenceServiceException {
        BorrowStub borrowStub = getBorrowStubFromRequest();
        //borrowStub.setState(MoneyTransferStates.ONPLATE);
        if(borrowStub.isValid()) {
            OfferListOnBorrowQuery offerList = borrowFacade.getOffers(borrowStub, request.getUserPrincipal());
            request.setAttribute(BorrowAttributes.OFFERS_ON_BORROW_QUERY, offerList);
        }else{
            request.setAttribute(GeneralAttributes.ERRORS, borrowStub.getErrors());
        }
        forward(Page.BORROW.getJspName());
    }

    private BorrowStub getBorrowStubFromRequest(){
        BorrowStub borrowStub=new BorrowStub();
        if(!request.getParameter(BorrowStub.BORROW_REPAYMENT_TYPE).isEmpty()) {
            borrowStub.setRepaymentType(request.getParameter(BorrowStub.BORROW_REPAYMENT_TYPE));
        }
        if(!request.getParameter(BorrowStub.BORROW_REPAYMENT_PERIOD_MONTH_MAX).isEmpty()) {
            borrowStub.setRepaymentDurationTo(Integer.parseInt(request.getParameter(BorrowStub.BORROW_REPAYMENT_PERIOD_MONTH_MAX)));
        }
        if(!request.getParameter(BorrowStub.BORROW_REPAYMENT_PERIOD_MONTH_MIN).isEmpty()) {
            borrowStub.setRepaymentDurationFrom(Integer.parseInt(request.getParameter(BorrowStub.BORROW_REPAYMENT_PERIOD_MONTH_MIN)));
        }
        return borrowStub;
    }



}
