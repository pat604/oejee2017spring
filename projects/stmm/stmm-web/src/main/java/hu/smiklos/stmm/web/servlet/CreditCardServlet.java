package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.ejb.domain.CreditCard.CreditCardStub;
import hu.smiklos.stmm.ejb.facade.WebFacades.CreditCard.CreditCardFacadeInterface;
import hu.smiklos.stmm.ejb.uribuilder.UriBuilder;
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
@WebServlet("/CreditCard")
public class CreditCardServlet extends BaseServlet {

    @EJB
    private CreditCardFacadeInterface facade;

    @Override
    public void handleGet() throws ServletException, IOException, PersistenceServiceException {
        boolean hasCreditcard =  facade.hasCreditCardAdded(request.getUserPrincipal());
        CreditCardStub cardStub = new CreditCardStub();
        if(hasCreditcard) {
            cardStub = facade.getCreditCard(request.getUserPrincipal());
            request.setAttribute(CreditCardAttributes.CARD_STUB,cardStub);
            request.setAttribute(CreditCardAttributes.HAS_CARD, hasCreditcard);
        }
        if(request.getParameter(Action.ACTION) != null){
            if(request.getParameter(Action.ACTION).equals(CreditCardAction.CONFIRM_DELETE_CREDITCARD)){
                Dialog dialog=new Dialog();
                dialog.setTitle("Confirm delete");
                dialog.setMessage("Do you really want to delete your credit card from Mooneybook system?");
                dialog.setButtontext("Delete");
                dialog.setUrl(Page.CREDIT_CARD.getUrl());
                dialog.setAction(CreditCardAction.DELETE_CARD_CONFIRMED);
                request.setAttribute(Dialog.ATTR_DIALOG,dialog);
            }
            if(request.getParameter(Action.ACTION).equals(CreditCardAction.DELETE_CARD_CONFIRMED)){
                if(cardStub.getCreditCardId() != null) {
                    facade.deleteCard(cardStub,request.getUserPrincipal());
                    request.setAttribute(Modal.ATTR_MODAL,getDeleteSucessModal());
                    request.setAttribute(CreditCardAttributes.CARD_STUB,null);
                    request.setAttribute(CreditCardAttributes.HAS_CARD, null);
                }
            }
        }
        forward(Page.CREDIT_CARD.getJspName());
    }

    @Override
    public void handlePost() throws ServletException, IOException, PersistenceServiceException {
        boolean hasCreditcard =  facade.hasCreditCardAdded(request.getUserPrincipal());

        CreditCardStub cardStub = new CreditCardStub();
        cardStub.setCreditcard_card_holder_name((String)request.getParameter(CreditCardStub.ATTR_CARD_HOLDER_NAME));
        cardStub.setCard_number((String)request.getParameter(CreditCardStub.ATTR_CARD_NUMBER));
        cardStub.setCreditcard_expiry_year((String)request.getParameter(CreditCardStub.ATTR_CARD_EXPIRY_YEAR));
        cardStub.setCreditcard_expiry_month((String)request.getParameter(CreditCardStub.ATTR_CARD_EXPIRY_MONTH));
        if(cardStub.isValid() && !hasCreditcard){
            this.createCreditCard(cardStub);
            request.setAttribute(Modal.ATTR_MODAL, getSuccessModalOnCreate());
            forward(Page.HOME.getJspName());
            return;
        }
        if(cardStub.isValid() && hasCreditcard){
            this.updateCreditCard(cardStub);
            request.setAttribute(Modal.ATTR_MODAL, getSuccessModalOnUpdate());
            forward(Page.HOME.getJspName());
            return;
        }
        request.setAttribute(CreditCardStub.ATTR_ERROR, cardStub.getErrors());
        forward(Page.CREDIT_CARD.getJspName());
    }

    private void updateCreditCard(CreditCardStub cardStub) throws PersistenceServiceException {
        facade.updateCreditCard(cardStub, request.getUserPrincipal());
    }

    private void createCreditCard(CreditCardStub cardStub) throws PersistenceServiceException {
        facade.createCreditCard(cardStub,request.getUserPrincipal());
    }

    private Modal getSuccessModalOnCreate() {
        Modal modal = new Modal();
        modal.setTitle("Creditcard added");
        modal.setMessage("Creditcard was added to your moneybook account, now you are able to invest or borrow money.");
        return modal;
    }
    private Modal getSuccessModalOnUpdate() {
        Modal modal = new Modal();
        modal.setTitle("Creditcard added");
        modal.setMessage("Creditcard was updated!");
        return modal;
    }


    public Object getDeleteSucessModal() {
        Modal modal = new Modal();
        modal.setTitle("Creditcard deleted");
        modal.setMessage("Creditcard was dleted from your moneybook account.");
        return modal;
    }
}
