package hu.smiklos.stmm.web.servlet;

import hu.smiklos.stmm.ejb.facade.MoneyTransferCreateFacadeInterface;
import hu.smiklos.stmm.ejb.facade.WalletFacade;
import hu.smiklos.stmm.ejb.facade.WalletFacadeInterface;
import hu.smiklos.stmm.pers.entity.MoneyTransfer;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.web.common.MoneyTransferAttributes;
import hu.smiklos.stmm.web.common.Page;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.security.Principal;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by SebestyenMiklos on 2017. 04. 16..
 */
@PermitAll
@WebServlet("/UserInvestments")
public class UserInvestmentsServlet extends BaseServlet {

    @EJB
    private WalletFacadeInterface walletFacade;

    @Override
    public void handleGet() throws ServletException, IOException, PersistenceServiceException {
        Set<MoneyTransfer> investments = walletFacade.getPrincipalWallet(request.getUserPrincipal()).getInvestments();
        request.setAttribute(MoneyTransferAttributes.INVESTMENTS, investments);
        forward(Page.INVESTMENT_LIST.getJspName());
    }

    @Override
    public void handlePost() throws ServletException, IOException, PersistenceServiceException {

    }

}
