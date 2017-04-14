package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.Wallet;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.parameter.WalletParameter;
import hu.smiklos.stmm.pers.query.WalletQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by SebestyenMiklos on 2017. 04. 14..
 */
@Stateless(mappedName = "pers/walletService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class WalletService implements WalletServiceInterface {

    private static final Logger LOGGER = Logger.getLogger(AppUserService.class);

    @PersistenceContext(unitName = UnitName.UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public Wallet read(String walletId) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get waller by id: " + walletId);
        }
        Wallet wallet = null;
        try {
            wallet = this.entityManager.createNamedQuery(WalletQuery.GET_WALLET_BY_ID, Wallet.class).setParameter(WalletParameter.WALLET_ID, walletId).getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching Wallet: " + walletId + "! " + e.getLocalizedMessage(), e);
        }
        return wallet;
    }

}
