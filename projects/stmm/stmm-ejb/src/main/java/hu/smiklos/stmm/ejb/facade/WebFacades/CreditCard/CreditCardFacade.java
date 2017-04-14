package hu.smiklos.stmm.ejb.facade.WebFacades.CreditCard;

import hu.smiklos.stmm.ejb.domain.CreditCard.CreditCardStub;
import hu.smiklos.stmm.pers.entity.AppUser;
import hu.smiklos.stmm.pers.entity.CreditCard;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.service.AppUserServiceInterface;
import hu.smiklos.stmm.pers.service.CreditCardService;
import hu.smiklos.stmm.pers.service.CreditCardServiceInterface;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.security.Principal;

/**
 * Created by SebestyenMiklos on 2017. 04. 06..
 */
@PermitAll
@Stateless
public class CreditCardFacade implements CreditCardFacadeInterface {

    @EJB
    private AppUserServiceInterface userService;

    @EJB
    private CreditCardServiceInterface ccService;

    @Override
    public boolean hasCreditCardAdded(Principal principal) throws PersistenceServiceException {
        AppUser appUser = getUserByPrincipal(principal);
        return appUser.getCreditCard() != null;
    }

    @Override
    public CreditCardStub getCreditCard(Principal userPrincipal) throws PersistenceServiceException {
        AppUser appUser = getUserByPrincipal(userPrincipal);
        CreditCard creditCard = appUser.getCreditCard();
        CreditCardStub stub = new CreditCardStub(creditCard);
        return stub;
    }

    @Override
    public void deleteCard(CreditCardStub cardStub, Principal principal) throws PersistenceServiceException {
        userService.deleteCreditCard(principal);
        ccService.delete(cardStub.getCreditCardId());
    }

    @Override
    public void createCreditCard(CreditCardStub creditCard, Principal principal) throws PersistenceServiceException {
        CreditCard card = creditCard.toCreditCard(getUserByPrincipal(principal));
        userService.addCreditCard(card,principal);

    }

    @Override
    public void updateCreditCard(CreditCardStub creditCardStub, Principal principal) throws PersistenceServiceException {
        AppUser appUser = getUserByPrincipal(principal);
        CreditCard card = creditCardStub.toCreditCard(appUser);
        userService.updateCreditCard(card,principal);
    }


    private AppUser getUserByPrincipal(Principal principal) throws PersistenceServiceException {
        String username = principal.getName();
        AppUser appUser = userService.getUserByUsername(username);
        return appUser;
    }
}
