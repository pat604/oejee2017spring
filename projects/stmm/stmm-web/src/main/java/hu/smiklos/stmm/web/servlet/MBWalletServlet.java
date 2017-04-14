package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.ejb.domain.CreditCard.CreditCardStub;
import hu.smiklos.stmm.ejb.domain.WalletStub;
import hu.smiklos.stmm.ejb.facade.AppUserFacadeInterface;
import hu.smiklos.stmm.ejb.facade.WalletFacadeInterface;
import hu.smiklos.stmm.ejb.facade.WebFacades.CreditCard.CreditCardFacadeInterface;
import hu.smiklos.stmm.pers.entity.CreditCard;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.web.common.Dialog;
import hu.smiklos.stmm.web.common.Page;
import hu.smiklos.stmm.web.common.WalletAttributes;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.security.Principal;

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
    public void handlePost() throws ServletException, IOException {
        forward(Page.MB_WALLET.getJspName());
    }

    @Override
    public void handleGet() throws ServletException, IOException, PersistenceServiceException {
        if(ccFacade.hasCreditCardAdded(request.getUserPrincipal())){
            WalletStub walletStub = walletFacade.getPrincipalWallet(request.getUserPrincipal());
            request.setAttribute(WalletAttributes.WALLET_STUB, walletStub );
            forward(Page.MB_WALLET.getJspName());
        }else{
            Dialog dialog = getCreditCardNotAddedDialog();
            request.setAttribute(Dialog.ATTR_DIALOG,dialog);
            forward(Page.HOME.getJspName());
            return;
        }

    }

    public Dialog getCreditCardNotAddedDialog(){
        Dialog dialog = new Dialog();
        dialog.setTitle("No creditcard ");
        dialog.setMessage("You have to add creditcard before accessing MB Wallet");
        dialog.setUrl(Page.CREDIT_CARD.getUrl());
        dialog.setButtontext("Add credit card");
        return dialog;
    }
}
