package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.BorrowStub;
import hu.smiklos.stmm.ejb.domain.OfferListOnBorrowQuery;
import hu.smiklos.stmm.pers.entity.MoneyTransfer;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.service.MoneyTransferServiceInterFace;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.security.Principal;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 04. 16..
 */
@PermitAll
@Stateless(mappedName = "ejb/BorrowFacade")
public class BorrowFacade implements BorrowFacadeInterface {

    @EJB
    private MoneyTransferServiceInterFace mtService;

    @Override
    public OfferListOnBorrowQuery getOffers(BorrowStub borrow, Principal principal) throws PersistenceServiceException {
       List<MoneyTransfer> unSortedOffers =  mtService.getOnPlateMoneyTransfersThatNotPrincipalOwns(borrow.getRepaymentType(),borrow.getRepaymentDurationFrom(),borrow.getRepaymentDurationTo(),principal);
       OfferListOnBorrowQuery list = new OfferListOnBorrowQuery();
       list.setOffers(unSortedOffers);
       return list;
    }

}