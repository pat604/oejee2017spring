package hu.smiklos.stmm.ejb.facade.WebFacades.CreditCard;

import hu.smiklos.stmm.ejb.domain.CreditCard.CreditCardStub;

import javax.ejb.Local;

/**
 * Created by SebestyenMiklos on 2017. 04. 06..
 */
@Local
public interface CreditCardFacadeInterface
{
    void createCreditCard(CreditCardStub creditCard);
    void updateCreditCard(CreditCardStub creditCard);
}
