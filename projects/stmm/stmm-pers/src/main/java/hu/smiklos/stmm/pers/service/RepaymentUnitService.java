package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.RepaymentUnit;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by SebestyenMiklos on 2017. 04. 20..
 */
@Stateless(mappedName = "pers/moneyTransferService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RepaymentUnitService implements RepaymentUnitServiceInterface {

    private static final Logger LOGGER = Logger.getLogger(AppUserService.class);
    @PersistenceContext(unitName = UnitName.UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public RepaymentUnit create(RepaymentUnit unit) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Create RepaymentUnit ("+ unit.getId() +")");
        }
        try {
            this.entityManager.persist(unit);
            return unit;
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during persisting RepaymentUnit (" + unit.getId() + ")! " + e.getLocalizedMessage(), e);
        }
    }
}
