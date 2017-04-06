package hu.smiklos.stmm.ejb.facade.WebFacades.CreditCard;

import javax.ejb.Local;
import java.security.Principal;

/**
 * Created by SebestyenMiklos on 2017. 04. 06..
 */
@Local
public interface CreditCardCheckFacade {
    boolean hasCreditCardAdded(Principal principal);
    boolean hasCreditCardValidated(Principal principal);
}
