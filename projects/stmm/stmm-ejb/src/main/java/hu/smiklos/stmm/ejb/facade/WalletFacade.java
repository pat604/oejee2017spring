package hu.smiklos.stmm.ejb.facade;

import hu.smiklos.stmm.ejb.domain.WalletStub;
import hu.smiklos.stmm.pers.entity.AppUser;
import hu.smiklos.stmm.pers.entity.Wallet;
import hu.smiklos.stmm.pers.exception.PersistenceServiceException;
import hu.smiklos.stmm.pers.service.AppUserService;
import hu.smiklos.stmm.pers.service.AppUserServiceInterface;
import hu.smiklos.stmm.pers.service.WalletServiceInterface;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.security.Principal;

/**
 * Created by SebestyenMiklos on 2017. 04. 14..
 */
@PermitAll
@Stateless(mappedName = "ejb/WalletFacade")
public class WalletFacade implements WalletFacadeInterface {

    @EJB
    private AppUserServiceInterface appUserService;

    @EJB
    private WalletServiceInterface walletService;

    @Override
    public WalletStub addCredit(int credit, Principal principal) throws PersistenceServiceException {
            WalletStub walletStub = getPrincipalWallet(principal);
            walletStub.setAmount(walletStub.getAmount()+credit);
            appUserService.addCredit(credit, principal);
            return walletStub;
    }

    @Override
    public WalletStub withdrawCredit(int credit, Principal principal) throws PersistenceServiceException {
        WalletStub walletStub = getPrincipalWallet(principal);
        if(walletStub.getAmount() >= credit) {
            walletStub.setAmount(walletStub.getAmount() - credit);
            appUserService.withdrawCredit(credit, principal);
        }
        return walletStub;
    }

    public WalletStub getPrincipalWallet(Principal principal) throws PersistenceServiceException {
        AppUser user = appUserService.getUserByUsername(principal.getName());
        if(user.getWallet() == null){
            Wallet wallet = new Wallet();
            wallet.setWallet_id("W-"+user.getUserId());
            wallet.setAmount(0);
            appUserService.addWallet(wallet, principal);

            WalletStub walletStub=new WalletStub(wallet);
            return walletStub;
        }
        return new WalletStub(user.getWallet());
    }


}
