package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.AppUser;
import hu.smiklos.stmm.pers.entity.CreditCard;
import hu.smiklos.stmm.pers.entity.Wallet;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.parameter.AppUserParameter;
import hu.smiklos.stmm.pers.query.AppUserQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.Principal;
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

    public AppUser getUserByUsername(String username) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get application user by username: " + username);
        }
        AppUser appUser = null;
        try {
            appUser = this.entityManager.createNamedQuery(AppUserQuery.GET_BY_USERNAME, AppUser.class).setParameter(AppUserParameter.USERNAME, username).getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching application user: " + username + "! " + e.getLocalizedMessage(), e);
        }
        return appUser;
    }

    @Override
    public CreditCard addCreditCard(CreditCard card, Principal principal) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Create CreditCard ("+ card.toString() +")");
        }
        try {

            AppUser appUser = this.getUserByUsername(principal.getName());
            appUser.setCreditCard(card);
            this.entityManager.merge(appUser);

            return card;
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during updating CreditCard (" + card.getCard_number() + ")! " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public CreditCard updateCreditCard(CreditCard card, Principal principal) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Updating Credit card : " + card.getCard_number());
        }
        try {
            this.entityManager.merge(card);

            AppUser appUser = this.getUserByUsername(principal.getName());

            appUser.setCreditCard(card);
            this.entityManager.merge(appUser);
            return card;

        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when merging Credit card! " + e.getLocalizedMessage(), e);
        }
    }

    public void deleteCreditCard(Principal principal) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Deleting Credit card!");
        }
        try {

            AppUser appUser = this.getUserByUsername(principal.getName());

            appUser.setCreditCard(null);
            this.entityManager.merge(appUser);

        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when merging Credit card! " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public Wallet addWallet(Wallet wallet, Principal principal) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Add wallet to user ("+ principal.getName() +") wallet: " + wallet.toString());
        }
        try {

            AppUser appUser = this.getUserByUsername(principal.getName());
            appUser.setWallet(wallet);
            this.entityManager.merge(appUser);

            return wallet;
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during adding Wallet (" + wallet.toString() + ")! " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void addCredit(double credit, Principal principal) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Add credit to wallet ("+ principal.getName() +") wallet: " + credit);
        }
        try {

            AppUser appUser = this.getUserByUsername(principal.getName());
            Wallet wallet = appUser.getWallet();
            wallet.setAmount(wallet.getAmount()+credit);
            appUser.setWallet(wallet);
            this.entityManager.merge(appUser);
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during adding credit to Wallet (" + credit + ")! " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void withdrawCredit(int credit, Principal principal) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Withdraw credit from wallet ("+ principal.getName() +") wallet: " + credit);
        }
        try {

            AppUser appUser = this.getUserByUsername(principal.getName());
            Wallet wallet = appUser.getWallet();
            if(wallet.getAmount() >= credit) {
                wallet.setAmount(wallet.getAmount() - credit);
                appUser.setWallet(wallet);
                this.entityManager.merge(appUser);
            }
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during money withdraw from Wallet (" + credit + ")! " + e.getLocalizedMessage(), e);
        }
    }

    public AppUser deleteCreditCard(String username) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get application user by username: " + username);
        }
        AppUser appUser = null;
        try {
            appUser = this.entityManager.createNamedQuery(AppUserQuery.GET_BY_USERNAME, AppUser.class).setParameter(AppUserParameter.USERNAME, username).getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching application user: " + username + "! " + e.getLocalizedMessage(), e);
        }
        return appUser;
    }




}
