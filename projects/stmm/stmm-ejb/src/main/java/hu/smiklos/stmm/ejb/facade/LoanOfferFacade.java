package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.LoanOfferStub;
import hu.smiklos.stmm.ejb.domain.MoneyTransferStub;
import hu.smiklos.stmm.ejb.domain.RepaymentUnitStub;
import hu.smiklos.stmm.pers.entity.MoneyTransfer;
import hu.smiklos.stmm.pers.entity.RepaymentUnit;
import hu.smiklos.stmm.pers.entity.trunk.MoneyTransferStates;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.service.AppUserServiceInterface;
import hu.smiklos.stmm.pers.service.MoneyTransferServiceInterFace;
import hu.smiklos.stmm.pers.service.RepaymentUnitServiceInterface;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.security.Principal;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 04. 18..
 */
@PermitAll
@Stateless(mappedName = "ejb/LoanOfferFacade")
public class LoanOfferFacade implements LoanOfferFacadeInterface {

    @EJB
    private MoneyTransferFacadeInterface mTransferFacade;

    @EJB
    private MoneyTransferServiceInterFace mtService;

    @EJB
    private RepaymentUnitServiceInterface repayService;

    @EJB
    private AppUserServiceInterface userService;


    @Override
    public LoanOfferStub checkOffer(String moneyTtransferId) throws PersistenceServiceException {
        MoneyTransferStub mTransferStub = mTransferFacade.getPreparedMoneyTransferStub(moneyTtransferId);
        LoanOfferStub offer= new LoanOfferStub(mTransferStub.toMoneyTransfer());
        return offer;
    }

    @Override
    public void acceptOffer(String moneyTransferId, Principal principal) throws PersistenceServiceException {
        MoneyTransfer mTransfer = updateMoneyTransferOfferTaken(moneyTransferId);
        persistRepaymentUnits(moneyTransferId,mTransfer);
        addMoneyToUserVallet(mTransfer.getTransfer_amount(), principal);
    }

    public void repayRepaymentUnit(RepaymentUnitStub stub){

    }

    private void addMoneyToUserVallet(double transfer_amount, Principal principal) throws PersistenceServiceException {
        userService.addCredit(transfer_amount,principal);
    }

    public MoneyTransfer updateMoneyTransferOfferTaken(String moneyTransferId) throws PersistenceServiceException {
        MoneyTransfer moneyTransfer = mtService.read(moneyTransferId);
        moneyTransfer.setTransferState(MoneyTransferStates.TAKEN);
        mtService.update(moneyTransfer);
        return moneyTransfer;
    }

    public void persistRepaymentUnits(String moneyTransferId, MoneyTransfer moneyTransfer) throws PersistenceServiceException {
        LoanOfferStub stub= this.checkOffer(moneyTransferId);
        List<RepaymentUnitStub> repaymentUnits = stub.getPayments();
        for(int i = 0; i< repaymentUnits.size(); i++){
            RepaymentUnit repUnit = repaymentUnits.get(i).toRepaymentUnit(stub,i,moneyTransfer);
            repayService.create(repUnit);
        }
    }
}
