package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.BorrowStub;
import hu.smiklos.stmm.pers.entity.MoneyTransfer;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.service.MoneyTransferServiceInterFace;
import hu.smiklos.stmm.remotelibrary.LoanOffersRemoteBean;
import hu.smiklos.stmm.ejb.domain.OfferListOnBorrowQuery;
import hu.smiklos.stmm.remotelibrary.entity.LoanOfferRemote;
import hu.smiklos.stmm.remotelibrary.exception.ServiceException;

import javax.annotation.security.PermitAll;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 04. 16..
 */
@PermitAll
@Stateless(mappedName = "ejb/BorrowFacade")
public class BorrowFacade implements BorrowFacadeInterface, LoanOffersRemoteBean {

    @EJB
    private MoneyTransferServiceInterFace mtService;

    @Override
    public OfferListOnBorrowQuery getOffers(BorrowStub borrow, Principal principal) throws PersistenceServiceException {
       List<MoneyTransfer> unSortedOffers =  mtService.getOnPlateMoneyTransfersByRepaymentType(borrow.getRepaymentType(),borrow.getRepaymentDurationFrom(),borrow.getRepaymentDurationTo(),principal);
       OfferListOnBorrowQuery list = new OfferListOnBorrowQuery();
       list.setOffers(unSortedOffers);
       return list;
    }

    @Override
    public OfferListOnBorrowQuery getOffers(String repayment_type) {
        List<MoneyTransfer> unSortedOffers =  mtService.getOnPlateMoneyTransfersByRepaymentType(repayment_type);
        OfferListOnBorrowQuery list = new OfferListOnBorrowQuery();
        list.setOffers(unSortedOffers);
        return list;
    }


    @Override
    public LoanOfferRemote[] getOffers(String repayment_type, String durationFrom, String durationTo) throws ServiceException {
        List<MoneyTransfer> unSortedOffers =  mtService.getOnPlateMoneyTransfersByRepaymentType(repayment_type);
        List<LoanOfferRemote> list= new ArrayList<LoanOfferRemote>();
        for(MoneyTransfer transfer: unSortedOffers){
            list.add(new LoanOfferRemote(transfer.getMoney_transfer_repayment_type().getRepayment_type_name(),
                    transfer.getMoneytransfer_investment_time_period_month(),
                    transfer.getTransfer_amount(),
                    transfer.getExpected_return_amount()-transfer.getTransfer_amount()));
        }
        return (LoanOfferRemote[])list.toArray();
    }
}
