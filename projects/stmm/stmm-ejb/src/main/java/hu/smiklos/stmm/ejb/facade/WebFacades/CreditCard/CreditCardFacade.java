package hu.smiklos.stmm.ejb.facade.WebFacades.CreditCard;

import hu.smiklos.stmm.ejb.domain.CreditCard.CreditCardStub;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import java.security.Principal;

/**
 * Created by SebestyenMiklos on 2017. 04. 06..
 */
@PermitAll
@Stateless
public class CreditCardFacade implements CreditCardCheckFacade, CreditCardFacadeInterface {



    @Override
    public boolean hasCreditCardAdded(Principal principal) {
        return false;
    }

    @Override
    public boolean hasCreditCardValidated(Principal principal) {
        return false;
    }

    @Override
    public void createCreditCard(CreditCardStub creditCard) {

    }

    @Override
    public void updateCreditCard(CreditCardStub creditCard) {

    }
}
