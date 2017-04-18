package hu.smiklos.stmm.pers.service;

import hu.smiklos.stmm.pers.entity.MoneyTransfer;
import hu.smiklos.stmm.pers.entity.RepaymentType;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import java.security.Principal;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 04. 15..
 */
public interface MoneyTransferServiceInterFace {

        MoneyTransfer create(MoneyTransfer moneyTransfer, Principal principal) throws PersistenceServiceException;

        MoneyTransfer update(MoneyTransfer moneyTransfer) throws PersistenceServiceException;

        String getNextMoneyTransferId(String day) throws PersistenceServiceException;

        List<RepaymentType> getRepaymentTypes() throws PersistenceServiceException;

        List<MoneyTransfer> getMoneyTransfers(String repaymentType, int repaymentDurationFrom, int getRepaymentDurationTo);
}
