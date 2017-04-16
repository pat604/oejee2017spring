package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.ejb.common.Errors;
import hu.smiklos.stmm.ejb.domain.MoneyTransferCreateStub;
import hu.smiklos.stmm.ejb.domain.WalletStub;
import hu.smiklos.stmm.ejb.facade.MoneyTransferCreateFacadeInterface;
import hu.smiklos.stmm.pers.entity.MoneyTransfer;
import hu.smiklos.stmm.pers.entity.Wallet;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.web.common.GeneralAttributes;
import hu.smiklos.stmm.web.common.MoneyTransferAttributes;
import hu.smiklos.stmm.web.common.Page;
import hu.smiklos.stmm.web.common.WalletAttributes;

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

    MoneyTransferCreateStub mtStub;
    WalletStub walletStub;
    @EJB
    private MoneyTransferCreateFacadeInterface mtFacade;

    @Override
    public void handleGet() throws ServletException, IOException, PersistenceServiceException {
        initAttributes();
        forward(Page.INVEST.getJspName());
    }

    @Override
    public void handlePost() throws ServletException, IOException, PersistenceServiceException {
        initAttributes();
        mtStub.setExpected_return_amount(Integer.parseInt(request.getParameter(MoneyTransferCreateStub.EXPECTED_RETURN_AMOUNT)));
        mtStub.setTransfer_amount(Integer.parseInt(request.getParameter(MoneyTransferCreateStub.TRANSFER_AMOUNT)));
        mtStub.setMoney_transfer_invest_period_month(Integer.parseInt(request.getParameter(MoneyTransferCreateStub.INVEST_TIME_PERIOD)));
        mtStub.setMoney_transfer_repayment_type(request.getParameter(MoneyTransferCreateStub.REPAYMENT_TYPE));
        if(mtStub.isValid()){
            createMoneyTransfer(mtStub);
            initAttributes();
        }else{
            request.setAttribute(GeneralAttributes.ERRORS,mtStub.getErrors());
        }
        request.setAttribute(MoneyTransferAttributes.MONEYTRANSFER_CREATE_STUB, mtStub);
        forward(Page.INVEST.getJspName());
    }

    private void createMoneyTransfer(MoneyTransferCreateStub mtStub) throws PersistenceServiceException {
        mtFacade.create(mtStub,request.getUserPrincipal());
    }

    private void initAttributes() throws PersistenceServiceException {
        mtStub = mtFacade.getPreparedMoneyTransferStub(request.getUserPrincipal());
        walletStub=new WalletStub(mtStub.getWallet_from());
        request.setAttribute(MoneyTransferAttributes.MONEYTRANSFER_CREATE_STUB, mtStub);
        request.setAttribute(WalletAttributes.WALLET_STUB, walletStub);
    }
}
