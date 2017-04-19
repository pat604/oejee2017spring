package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.converter.DateConverter;
import hu.smiklos.stmm.ejb.domain.MoneyTransferStub;
import hu.smiklos.stmm.pers.entity.MoneyTransfer;
import hu.smiklos.stmm.pers.entity.Wallet;
import hu.smiklos.stmm.pers.entity.trunk.MoneyTransferStates;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.service.AppUserServiceInterface;
import hu.smiklos.stmm.pers.service.MoneyTransferServiceInterFace;
import hu.smiklos.stmm.pers.service.WalletServiceInterface;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.security.Principal;
import java.util.Date;

/**
 * Created by SebestyenMiklos on 2017. 04. 15..
 */
@PermitAll
@Stateless(mappedName = "ejb/MoneyTransferFacede")
public class MoneyTransferFacade implements MoneyTransferFacadeInterface {

    @EJB
    private MoneyTransferServiceInterFace mtService;

    @EJB
    private WalletServiceInterface walletService;

    @EJB
    private AppUserServiceInterface userService;

    @Override
    public void create(MoneyTransferStub mtStub, Principal principal) throws PersistenceServiceException {
        if(!mtStub.isValid()){
            return;
        }
        if(mtStub.getMoneytransfer_id() == null){
            String day = DateConverter.getDateAsContinouesString(new Date());
            mtStub.setMoneytransfer_id(mtService.getNextMoneyTransferId(day));
        }

        if(mtStub.getWallet_from() == null){
            Wallet userWallet = userService.getUserByUsername(principal.getName()).getWallet();
            mtStub.setWallet_from(userWallet);

        }
        mtStub.setState(MoneyTransferStates.ONPLATE);
        MoneyTransfer mTransfer = mtStub.toMoneyTransfer();
        mtService.create(mTransfer,principal);



    }

    @Override
    public MoneyTransferStub getPreparedMoneyTransferStub(Principal principal) throws PersistenceServiceException {
        MoneyTransferStub mtStub = new MoneyTransferStub();
        mtStub.setWallet_from(userService.getUserByUsername(principal.getName()).getWallet());
        mtStub.setExpected_return_amount(0);
        mtStub.setTransfer_amount(0);
        mtStub.setMoney_transfer_repayment_types(mtService.getRepaymentTypes());
        return mtStub;
    }

    @Override
    public MoneyTransferStub getPreparedMoneyTransferStub(String moneyTtransferId) throws PersistenceServiceException {

        MoneyTransfer mTransfer = mtService.read(moneyTtransferId);
        MoneyTransferStub mtStub = new MoneyTransferStub(mTransfer);

        return mtStub;
    }
}
