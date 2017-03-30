package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.AppUser;
import hu.smiklos.stmm.pers.entity.UserType;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.query.AppUserQuery;
import hu.smiklos.stmm.pers.query.UsertypesQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


/**
 * Created by SebestyenMiklos on 2017. 03. 26..
 */
@Stateless(mappedName = "pers/userTypeService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class UserTypeService implements UserTypeServiceInterface {

    @PersistenceContext(unitName = UnitName.UNIT_NAME)
    private EntityManager entityManager;

    private static final Logger LOGGER = Logger.getLogger(AppUserService.class);

    @Override
    public List<UserType> readAll() throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get all application users");
        }
        List<UserType> result = null;
        try {
            result = this.entityManager.createNamedQuery(UsertypesQuery.GET_ALL, UserType.class).getResultList();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching application users! " + e.getLocalizedMessage(), e);
        }
        return result;
    }
}
