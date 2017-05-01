package hu.smiklos.stmm.restservice;

import hu.smiklos.stmm.ejb.domain.LoanOfferForRestStub;
import hu.smiklos.stmm.ejb.domain.OfferListOnBorrowQuery;
import hu.smiklos.stmm.ejb.facade.BorrowFacadeInterface;
import hu.smiklos.stmm.pers.entity.MoneyTransfer;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 05. 01..
 */
@Stateless
public class LoanQueryRestService implements LoanQueryRestServiceInterface {

    @EJB
    private BorrowFacadeInterface borrowFacade;

    @Override
    public List<LoanOfferForRestStub> getOffers(String repayment_type) throws PersistenceServiceException {

        OfferListOnBorrowQuery result = borrowFacade.getOffers(repayment_type);
        List<LoanOfferForRestStub> loanList = new ArrayList<LoanOfferForRestStub>();
        for(MoneyTransfer transfer : result.getOffers()){
            loanList.add(new LoanOfferForRestStub(
                    transfer.getTransfer_amount(),
                    transfer.getExpected_return_amount(),
                    transfer.getMoney_transfer_repayment_type().getRepayment_type_name(),
                    transfer.getExpected_return_amount() - transfer.getTransfer_amount(),
                    transfer.getMoneytransfer_investment_time_period_month()
            ));
        }
        return loanList;
    }
}
