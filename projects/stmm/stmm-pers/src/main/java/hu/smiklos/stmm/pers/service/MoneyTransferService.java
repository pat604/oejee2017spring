package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.MoneyTransfer;
import hu.smiklos.stmm.pers.entity.MoneyTransferPerDay;
import hu.smiklos.stmm.pers.entity.RepaymentType;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.parameter.MoneyTransferPerDayParameter;
import hu.smiklos.stmm.pers.parameter.RegPerDayParameter;
import hu.smiklos.stmm.pers.query.MoneyTransferPerDayQuery;
import hu.smiklos.stmm.pers.query.RegPerDayQuery;
import hu.smiklos.stmm.pers.query.RepaymentTypeQuery;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 04. 15..
 */
@Stateless(mappedName = "pers/moneyTransferService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MoneyTransferService implements MoneyTransferServiceInterFace {

    private static final Logger LOGGER = Logger.getLogger(AppUserService.class);

    @PersistenceContext(unitName = UnitName.UNIT_NAME)
    private EntityManager entityManager;

    @Override
    public MoneyTransfer create(MoneyTransfer moneyTransfer) throws PersistenceServiceException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Create MoneyTransfer ("+ moneyTransfer.toString() +")");
        }
        try {
            this.entityManager.persist(moneyTransfer);
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


}
