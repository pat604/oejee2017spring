package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.ejb.domain.MoneyTransferStub;
import hu.smiklos.stmm.ejb.domain.WalletStub;
import hu.smiklos.stmm.ejb.facade.MoneyTransferFacadeInterface;
import hu.smiklos.stmm.pers.entity.MoneyTransfer;
import hu.smiklos.stmm.pers.entity.trunk.MoneyTransferStates;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.web.common.*;

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

    MoneyTransferStub mtStub;
    WalletStub walletStub;
    @EJB
    private MoneyTransferFacadeInterface mtFacade;

    @Override
    public void handleGet() throws ServletException, IOException, PersistenceServiceException {

        if(request.getParameter(MoneyTransferStub.MONEY_TRANSFER_ID_TO_DELETE_INVESTMENT) != null){
            deleteInvestment(request.getParameter(MoneyTransferStub.MONEY_TRANSFER_ID_TO_DELETE_INVESTMENT));
        }
        initAttributes();
        forward(Page.INVEST.getJspName());
    }

    @Override
    public void handlePost() throws ServletException, IOException, PersistenceServiceException {
        initAttributes();
        mtStub.setExpected_return_amount(Integer.parseInt(request.getParameter(MoneyTransferStub.EXPECTED_RETURN_AMOUNT)));
        mtStub.setTransfer_amount(Integer.parseInt(request.getParameter(MoneyTransferStub.TRANSFER_AMOUNT)));
        mtStub.setMoney_transfer_invest_period_month(Integer.parseInt(request.getParameter(MoneyTransferStub.INVEST_TIME_PERIOD)));
        mtStub.setMoney_transfer_repayment_type(request.getParameter(MoneyTransferStub.REPAYMENT_TYPE));
        if(mtStub.isValid()){
            createMoneyTransfer(mtStub);
            initAttributes();
        }else{
            request.setAttribute(GeneralAttributes.ERRORS,mtStub.getErrors());
        }
        request.setAttribute(MoneyTransferAttributes.MONEYTRANSFER_CREATE_STUB, mtStub);
        forward(Page.INVEST.getJspName());
    }

    private void deleteInvestment(String investmentId) throws PersistenceServiceException {
        if(isInvestmentDeletable(investmentId)) {
            mtFacade.deleteInvestment(investmentId, request.getUserPrincipal());
            Modal modal = new Modal();
            modal.setTitle("Investment deleted!");
            modal.setMessage("Your investment has been deleted successfully.");
            request.setAttribute(Modal.ATTR_MODAL, modal);
        } else {
            Modal modal = new Modal();
            modal.setTitle("Investment cannot be deleted!");
            modal.setMessage("Your investment is being taken! Please refresh your browser.");
            request.setAttribute(Modal.ATTR_MODAL, modal);
        }

    }

    private boolean isInvestmentDeletable(String investmentId) throws PersistenceServiceException {
        boolean isDeletable = mtFacade.isDeletable(investmentId, request.getUserPrincipal());
        return isDeletable;

    }




    private void createMoneyTransfer(MoneyTransferStub mtStub) throws PersistenceServiceException {
        mtFacade.create(mtStub,request.getUserPrincipal());
    }

    private void initAttributes() throws PersistenceServiceException {
        mtStub = mtFacade.getPreparedMoneyTransferStub(request.getUserPrincipal());
        walletStub=new WalletStub(mtStub.getWallet_from());
        request.setAttribute(MoneyTransferAttributes.MONEYTRANSFER_CREATE_STUB, mtStub);
        request.setAttribute(WalletAttributes.WALLET_STUB, walletStub);
    }
}
