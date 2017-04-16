package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.AppUser;
import hu.smiklos.stmm.pers.entity.Wallet;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.parameter.WalletParameter;
import hu.smiklos.stmm.pers.query.WalletQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.Principal;

/**
 * Created by SebestyenMiklos on 2017. 04. 14..
 */
@Stateless(mappedName = "pers/walletService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class WalletService implements WalletServiceInterface {

    private static final Logger LOGGER = Logger.getLogger(AppUserService.class);
    @EJB
    private AppUserServiceInterface userService;
    @PersistenceContext(unitName = UnitName.UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public Wallet read(String walletId) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get waller by id: " + walletId);
        }
        Wallet wallet;
        try {
            wallet = this.entityManager.createNamedQuery(WalletQuery.GET_WALLET_BY_ID, Wallet.class).setParameter(WalletParameter.WALLET_ID, walletId).getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching Wallet: " + walletId + "! " + e.getLocalizedMessage(), e);
        }
        return wallet;
    }

    @Override
    public Wallet getAppUserWallet(Principal principal) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get wallet by username: " + principal.getName());
        }
        Wallet wallet;
        try {
            AppUser user= userService.getUserByUsername(principal.getName());
            wallet = this.entityManager.createNamedQuery(WalletQuery.GET_WALLET_BY_ID, Wallet.class).setParameter(WalletParameter.WALLET_ID, user.getWallet().getWallet_id() ).getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching Wallet for: " + principal.getName() + "! " + e.getLocalizedMessage(), e);
        }
        return wallet;
    }

}
