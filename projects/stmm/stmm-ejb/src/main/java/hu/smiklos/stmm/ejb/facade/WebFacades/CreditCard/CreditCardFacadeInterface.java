package hu.smiklos.stmm.ejb.facade.WebFacades.CreditCard;

import hu.smiklos.stmm.ejb.domain.CreditCard.CreditCardStub;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.Local;
import java.security.Principal;

/**
 * Created by SebestyenMiklos on 2017. 04. 06..
 */
@Local
public interface CreditCardFacadeInterface
{
    void createCreditCard(CreditCardStub creditCard, Principal principal) throws PersistenceServiceException;
    void updateCreditCard(CreditCardStub creditCard, Principal principal) throws PersistenceServiceException;
    boolean hasCreditCardAdded(Principal principal) throws PersistenceServiceException;
    CreditCardStub getCreditCard(Principal userPrincipal) throws PersistenceServiceException;
}
