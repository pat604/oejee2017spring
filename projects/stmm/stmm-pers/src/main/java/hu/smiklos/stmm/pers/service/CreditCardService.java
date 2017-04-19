package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.AppUser;
import hu.smiklos.stmm.pers.entity.CreditCard;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.parameter.AppUserParameter;
import hu.smiklos.stmm.pers.parameter.CreditCardParameter;
import hu.smiklos.stmm.pers.query.AppUserQuery;

import hu.smiklos.stmm.pers.query.CreditCardQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


/**
 * Created by SebestyenMiklos on 2017. 04. 12..
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CreditCardService implements CreditCardServiceInterface {

    private static final Logger LOGGER = Logger.getLogger(AppUserService.class);

    @PersistenceContext(unitName = UnitName.UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public CreditCard readByCreditCardId(String creditcard_id) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get creditcard: " + creditcard_id);
        }
        CreditCard card = null;
        try {
            card = this.entityManager.createNamedQuery(CreditCardQuery.GET_BY_CREDITCARD_ID, CreditCard.class).getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching credit card by id: " + e.getLocalizedMessage(), e);
        }
        return card;
    }

    @Override
    public void delete(String creditcard_id) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Remove Credit card by id (" + creditcard_id + ")");
        }
        try {
            this.entityManager.createNamedQuery(CreditCardQuery.DELETE_BY_CREDITCARD_ID).setParameter(CreditCardParameter.CARD_ID, creditcard_id).executeUpdate();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when removing Creditcard by creditcard_id (" + creditcard_id + ")! " + e.getLocalizedMessage(), e);
        }
    }
}
