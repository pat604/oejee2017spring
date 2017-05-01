package hu.smiklos.stmm.restservice;

import hu.smiklos.stmm.ejb.domain.BorrowStub;
import hu.smiklos.stmm.ejb.domain.LoanOfferForRestStub;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by SebestyenMiklos on 2017. 05. 01..
 */
@Path("/loanquery")
public interface LoanQueryRestServiceInterface {


    @GET
    @Path("/{"+BorrowStub.BORROW_REPAYMENT_TYPE+"}")
    @Produces("application/json")
    List<LoanOfferForRestStub> getOffers(@PathParam(BorrowStub.BORROW_REPAYMENT_TYPE) String repayment_type) throws PersistenceServiceException;

}
