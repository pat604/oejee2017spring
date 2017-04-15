package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.ejb.domain.MoneyTransferCreateStub;
import hu.smiklos.stmm.ejb.facade.MoneyTransferCreateFacadeInterface;
import hu.smiklos.stmm.pers.entity.MoneyTransfer;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.web.common.MoneyTransferAttributes;
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
@WebServlet("/Invest")
public class InvestServlet extends BaseServlet {

    @EJB
    private MoneyTransferCreateFacadeInterface mtFacade;

    @Override
    public void handlePost() throws ServletException, IOException, PersistenceServiceException {
        MoneyTransferCreateStub mtStub = mtFacade.getPreparedMoneyTransferStub(request.getUserPrincipal());
        mtStub.setExpected_return_amount(Integer.parseInt(request.getParameter(MoneyTransferCreateStub.EXPECTED_RETURN_AMOUNT)));
        mtStub.setTransfer_amount(Integer.parseInt(request.getParameter(MoneyTransferCreateStub.TRANSFER_AMOUNT)));
        mtStub.setMoney_transfer_invest_period_month(Integer.parseInt(request.getParameter(MoneyTransferCreateStub.INVEST_TIME_PERIOD)));
        mtStub.setMoney_transfer_repayment_type(request.getParameter(MoneyTransferCreateStub.REPAYMENT_TYPE));
        request.setAttribute(MoneyTransferAttributes.MONEYTRANSFER_CREATE_STUB, mtStub);
        forward(Page.INVEST.getJspName());
    }

    @Override
    public void handleGet() throws ServletException, IOException, PersistenceServiceException {
        MoneyTransferCreateStub mtStub = mtFacade.getPreparedMoneyTransferStub(request.getUserPrincipal());
        request.setAttribute(MoneyTransferAttributes.MONEYTRANSFER_CREATE_STUB, mtStub);
        forward(Page.INVEST.getJspName());
    }
}
