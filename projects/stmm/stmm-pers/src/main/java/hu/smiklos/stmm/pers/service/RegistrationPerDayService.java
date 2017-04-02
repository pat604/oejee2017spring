package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.RegistrationPerDay;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.parameter.RegPerDayParameter;
import hu.smiklos.stmm.pers.query.RegPerDayQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by SebestyenMiklos on 2017. 04. 02..
 */
@Stateless(mappedName = "ejb/registrationPerDayService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RegistrationPerDayService implements RegistrationPerDayInterface {

    private static final Logger LOGGER = Logger.getLogger(RegistrationPerDayService.class);

    @PersistenceContext(unitName = UnitName.UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public boolean exists(String day) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Check RegPerDay (" + day + ")");
        }
        try {
            return this.entityManager.createNamedQuery(RegPerDayQuery.EXISTS, Long.class).setParameter(RegPerDayParameter.DAY, day ).getSingleResult() == 1;

        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during counting RegPerDay (" + day + ")! " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public RegistrationPerDay read(String day) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get Registration per day by day (" + day + ")");
        }
        RegistrationPerDay result = null;
        try {
            result = this.entityManager.createNamedQuery(RegPerDayQuery.GET_DAY, RegistrationPerDay.class).setParameter(RegPerDayParameter.DAY, day).getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching Registrations per day by day (" + day + ")! " + e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public RegistrationPerDay update(RegistrationPerDay day) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Update registration_per_day:" + day.toString());
        }
        try {
            return this.entityManager.merge(day);
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when mergning registration_per_day! " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public RegistrationPerDay create(RegistrationPerDay day) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Create Registration per day: " + day.toString());
        }
        try {
            this.entityManager.persist(day);
            return day;
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during persisting Registration per day (" + day.getDay() + ")! " + e.getLocalizedMessage(), e);
        }
    }
}
