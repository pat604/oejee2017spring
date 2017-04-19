package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.*;
import hu.smiklos.stmm.pers.entity.trunk.MoneyTransferStates;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.parameter.MoneyTransferParameter;
import hu.smiklos.stmm.pers.parameter.MoneyTransferPerDayParameter;
import hu.smiklos.stmm.pers.parameter.RegPerDayParameter;
import hu.smiklos.stmm.pers.query.MoneyTransferPerDayQuery;
import hu.smiklos.stmm.pers.query.MoneyTransferQuery;
import hu.smiklos.stmm.pers.query.RegPerDayQuery;
import hu.smiklos.stmm.pers.query.RepaymentTypeQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by SebestyenMiklos on 2017. 04. 15..
 */
@Stateless(mappedName = "pers/moneyTransferService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MoneyTransferService implements MoneyTransferServiceInterFace {


    private static final Logger LOGGER = Logger.getLogger(AppUserService.class);
    @EJB
    private AppUserServiceInterface userService;
    @PersistenceContext(unitName = UnitName.UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public MoneyTransfer read(String moneyTransferId) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get MoneyTransfer by id: " + moneyTransferId);
        }
        MoneyTransfer mTransfer = null;
        try {
            mTransfer = this.entityManager.createNamedQuery(MoneyTransferQuery.GET_BY_ID, MoneyTransfer.class).setParameter(MoneyTransferParameter.ID, moneyTransferId).getSingleResult();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when fetching MoneyTransfer by id: " + moneyTransferId + "! " + e.getLocalizedMessage(), e);
        }
        return mTransfer;
    }

    @Override
    public MoneyTransfer create(MoneyTransfer moneyTransfer, Principal principal) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Create MoneyTransfer ("+ moneyTransfer.toString() +")");
        }
        try {
            this.entityManager.persist(moneyTransfer);
            removeInvestedAmountFromWallet(moneyTransfer,principal);
            return moneyTransfer;
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during persisting MoneyTransfer (" + moneyTransfer.getMoneytransfer_id() + ")! " + e.getLocalizedMessage(), e);
        }
    }

    public MoneyTransfer update(MoneyTransfer moneyTransfer) throws PersistenceServiceException {
        return null;
    }

    /**
     *
     * @param day //yyyymmdd eg.: 19960325
     * @return
     * @throws PersistenceServiceException
     */
    public String getNextMoneyTransferId(String day) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Returning next MoneyTransfer id");
        }
        try {
            MoneyTransferPerDay mtPerDay=new MoneyTransferPerDay();
           boolean dayRecordExist = this.entityManager.createNamedQuery(MoneyTransferPerDayQuery.EXISTS, Long.class).setParameter(MoneyTransferPerDayParameter.DAY, day ).getSingleResult() > 0;
           if(!dayRecordExist){
               mtPerDay=new MoneyTransferPerDay();
               mtPerDay.setDay(day);
               mtPerDay.setCount(1);
               this.entityManager.persist(mtPerDay);

           }else{
               mtPerDay = this.entityManager.createNamedQuery(MoneyTransferPerDayQuery.GET_DAY, MoneyTransferPerDay.class).setParameter(MoneyTransferPerDayParameter.DAY, day).getSingleResult();
               mtPerDay.setCount(mtPerDay.getCount()+1);
               this.entityManager.merge(mtPerDay);
           }
            return String.format("MT-%s-%d",mtPerDay.getDay(),mtPerDay.getCount());
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during requesting next MoneyTransfer id" + e.getLocalizedMessage(), e);
        }

    }

    @Override
    public List<RepaymentType> getRepaymentTypes() throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(" getRepaymentTypes ");
        }
        try {
            List<RepaymentType> types = this.entityManager.createNamedQuery(RepaymentTypeQuery.GET_ALL_REPAYMENT_TYPE, RepaymentType.class).getResultList();
            return types;
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during getRepaymentTypes  " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<MoneyTransfer> getOnPlateMoneyTransfersThatNotPrincipalOwns(String repaymentType, int repaymentDurationFrom, int repaymentDurationTo, Principal principal) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("Select all on plate MoneyTransfers tahat has: repayment_type("+repaymentType+")"+"repayment between("+repaymentDurationFrom+"-"+repaymentDurationTo+")");
        }
        String walletId = userService.getUserByUsername(principal.getName()).getWallet().getWallet_id();

        List<MoneyTransfer> transfers = new ArrayList<MoneyTransfer>();
        transfers = entityManager.createNamedQuery(MoneyTransferQuery.GET_BY_BORROW_QUERY,MoneyTransfer.class)
                .setParameter(MoneyTransferParameter.REPAYMENT_TYPE,repaymentType)
                .setParameter(MoneyTransferParameter.WALLET_ID, walletId)
                .setParameter(MoneyTransferParameter.MONEY_TRANSFER_STATE,  hu.smiklos.stmm.pers.entity.trunk.MoneyTransferStates.ONPLATE)
                .setParameter(MoneyTransferParameter.REPAYMENT_MONTHS_FROM, repaymentDurationFrom)
                .setParameter(MoneyTransferParameter.REPAYMENT_MONTHS_TO,repaymentDurationTo)
                .getResultList();
        return transfers;
    }

    @Override
    public void delete(String moneyTransferId) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Remove MoneyTransfer by id (" + moneyTransferId + ")");
        }
        try {
            this.entityManager.createNamedQuery(MoneyTransferQuery.DELETE_BY_ID).setParameter(MoneyTransferParameter.ID, moneyTransferId).executeUpdate();
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error when removing MoneyTransfer by id (" + moneyTransferId + ")! " + e.getLocalizedMessage(), e);
        }
    }

    private void removeInvestedAmountFromWallet(MoneyTransfer moneyTransfer, Principal principal) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Remove credit from wallet because of Investment ("+ principal.getName() +") investment: " + moneyTransfer.getMoneytransfer_id());
        }
        try {

            AppUser appUser = userService.getUserByUsername(principal.getName());
            Wallet wallet = appUser.getWallet();
            if(wallet.getAmount() >= moneyTransfer.getTransfer_amount()) {
                wallet.setAmount(wallet.getAmount() - moneyTransfer.getTransfer_amount());
                appUser.setWallet(wallet);
                this.entityManager.merge(appUser);
            }
        } catch (final Exception e) {
            throw new PersistenceServiceException("Unknown error during removing credit from Wallet because of investment (" + moneyTransfer.getTransfer_amount() + ")! " + e.getLocalizedMessage(), e);
        }
    }


}
