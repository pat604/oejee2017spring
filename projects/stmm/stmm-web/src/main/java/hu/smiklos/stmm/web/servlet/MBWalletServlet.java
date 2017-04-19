package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.ejb.domain.WalletStub;
import hu.smiklos.stmm.ejb.facade.WalletFacadeInterface;
import hu.smiklos.stmm.ejb.facade.WebFacades.CreditCard.CreditCardFacadeInterface;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.web.common.Dialog;
import hu.smiklos.stmm.web.common.Modal;
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
@WebServlet("/MBWallet")
public class MBWalletServlet extends BaseServlet {

    @EJB
    private CreditCardFacadeInterface ccFacade;

    @EJB
    private WalletFacadeInterface walletFacade;

    @Override
    public void handleGet() throws ServletException, IOException, PersistenceServiceException {
        updateWalletDataForJsp();
    }

    @Override
    public void handlePost() throws ServletException, IOException, PersistenceServiceException {
        if(request.getParameter(WalletAttributes.ADDCREDIT_INPUT) != null){
            this.addCredit();
        }
        if(request.getParameter(WalletAttributes.WITHDRAW_INPUT) != null){
            this.withdrawCredit();
        }
        updateWalletDataForJsp();
    }

    private void withdrawCredit() throws PersistenceServiceException {
        WalletStub walletStub = walletFacade.getPrincipalWalletStub(request.getUserPrincipal());
        int withdrawAmount = Integer.parseInt(request.getParameter(WalletAttributes.WITHDRAW_INPUT));
        if(walletStub.getAmount() >= withdrawAmount ){
            walletFacade.withdrawCredit(withdrawAmount, request.getUserPrincipal());
            request.setAttribute(Modal.ATTR_MODAL, getCreditWithdrawnModal(withdrawAmount));
        }else{
            request.setAttribute(Modal.ATTR_MODAL,getNotEnoughMoneyToWithdrawModal());
        }
    }

    private void addCredit() throws PersistenceServiceException {
        int creditToAdd = Integer.parseInt(request.getParameter(WalletAttributes.ADDCREDIT_INPUT));
        walletFacade.addCredit(creditToAdd,request.getUserPrincipal());
        request.setAttribute(Modal.ATTR_MODAL,getCreditAddedModal(creditToAdd));
    }



    public Dialog getCreditCardNotAddedDialog(){
        Dialog dialog = new Dialog();
        dialog.setTitle("No creditcard ");
        dialog.setMessage("You have to add creditcard before accessing MB Wallet");
        dialog.setUrl(Page.CREDIT_CARD.getUrl());
        dialog.setButtontext("Add credit card");
        return dialog;
    }

    public Modal getNotEnoughMoneyToWithdrawModal(){
        Modal modal = new Modal();
        modal.setTitle("Not enough credit");
        modal.setMessage("You cannot withdraw that much credit!");
        return modal;
    }

    public Modal getCreditAddedModal(int credit){
        Modal modal = new Modal();
        modal.setTitle("Credit added!");
        modal.setMessage("You have added "+credit+" MBC to your MB Wallet.");
        return modal;
    }

    public void updateWalletDataForJsp() throws PersistenceServiceException, ServletException, IOException {
        if(ccFacade.hasCreditCardAdded(request.getUserPrincipal())){
            WalletStub walletStub = walletFacade.getPrincipalWalletStub(request.getUserPrincipal());
            request.setAttribute(WalletAttributes.WALLET_STUB, walletStub );
            forward(Page.MB_WALLET.getJspName());
            return;
        }else{
            Dialog dialog = getCreditCardNotAddedDialog();
            request.setAttribute(Dialog.ATTR_DIALOG,dialog);
            forward(Page.HOME.getJspName());
            return;
        }
    }

    public Modal getCreditWithdrawnModal(int credit){
        Modal modal = new Modal();
        modal.setTitle("Credit withdraw!");
        modal.setMessage("You have taken "+credit+" MBC to your Credit card.");
        return modal;
    }
}
