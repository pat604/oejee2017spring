package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.AppUser;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.parameter.AppUserParameter;
import hu.smiklos.stmm.pers.query.AppUserQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.print.Book;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 03. 16..
 */
@Stateless(mappedName = "pers/appUserService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AppUserService implements AppUserServiceInterface {

    private static final Logger LOGGER = Logger.getLogger(AppUserService.class);

    @PersistenceContext(unitName = UnitName.UNIT_NAME)
    private EntityManager entityManager;


    @Override
    public List<AppUser> readAll() throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get all application users");
        }
        List<AppUser> result = null;
        try {
            result = this.entityManager.createNamedQuery(AppUserQuery.GET_ALL, AppUser.class).getResultList();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching application users! " + e.getLocalizedMessage(), e);
        }
        return result;
    }

    @Override
    public AppUser read(String appuserId) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get application user by id: " + appuserId);
        }
        AppUser appUser = null;
        try {
            appUser = this.entityManager.createNamedQuery(AppUserQuery.GET_BY_ID, AppUser.class).setParameter(AppUserParameter.ID, appuserId).getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching application user: " + appuserId + "! " + e.getLocalizedMessage(), e);
        }
        return appUser;
    }

    @Override
    public AppUser create(AppUser user) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Create User ("+ user.toString() +")");
        }
        try {
            this.entityManager.persist(user);
            return user;
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during persisting AppUser (" + user.getUserId() + ")! " + e.getLocalizedMessage(), e);
        }
    }
}
