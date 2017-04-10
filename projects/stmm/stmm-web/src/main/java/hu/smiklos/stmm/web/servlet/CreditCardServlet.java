package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.ejb.domain.CreditCard.CreditCardStub;
import hu.smiklos.stmm.ejb.facade.WebFacades.CreditCard.CreditCardFacadeInterface;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.web.common.CreditCardAttributes;
import hu.smiklos.stmm.web.common.Modal;
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
@WebServlet("/CreditCard")
public class CreditCardServlet extends BaseServlet {

    @EJB
    private CreditCardFacadeInterface facade;

    @Override
    public void handlePost() throws ServletException, IOException, PersistenceServiceException {
        boolean hasCreditcard =  facade.hasCreditCardAdded(request.getUserPrincipal());

        CreditCardStub cardStub = new CreditCardStub();
        cardStub.setCreditcard_card_holder_name((String)request.getParameter(CreditCardStub.ATTR_CARD_HOLDER_NAME));
        cardStub.setCard_number((String)request.getParameter(CreditCardStub.ATTR_CARD_NUMBER));
        cardStub.setCreditcard_expiry_year((String)request.getParameter(CreditCardStub.ATTR_CARD_EXPIRY_YEAR));
        cardStub.setCreditcard_expiry_month((String)request.getParameter(CreditCardStub.ATTR_CARD_EXPIRY_MONTH));
        if(cardStub.isValid()){
            this.createCreditCard(cardStub);
            request.setAttribute(Modal.ATTR_MODAL,getSuccessModal());
            forward(Page.HOME.getJspName());
            return;
        }
        request.setAttribute(CreditCardStub.ATTR_ERROR, cardStub.getErrors());
        forward(Page.CREDIT_CARD.getJspName());
    }

    private void createCreditCard(CreditCardStub cardStub) throws PersistenceServiceException {
        facade.createCreditCard(cardStub,request.getUserPrincipal());
    }

    private Modal getSuccessModal() {
        Modal modal = new Modal();
        modal.setTitle("Creditcard added");
        modal.setMessage("Creditcard was added to your moneybook account, now you are able to invest or borrow money.");
        return modal;
    }

    @Override
    public void handleGet() throws ServletException, IOException, PersistenceServiceException {
        boolean hasCreditcard =  facade.hasCreditCardAdded(request.getUserPrincipal());
        CreditCardStub cardStub;
        if(hasCreditcard) {
            cardStub = facade.getCreditCard(request.getUserPrincipal());
            request.setAttribute(CreditCardAttributes.CARD_STUB,cardStub);
            request.setAttribute(CreditCardAttributes.HAS_CARD, hasCreditcard);
        }
        forward(Page.CREDIT_CARD.getJspName());
    }
}
