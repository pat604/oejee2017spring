package hu.smiklos.stmm.ejb.converter;

import hu.smiklos.stmm.ejb.domain.AppUserStub;
import hu.smiklos.stmm.pers.entity.AppUser;

import javax.ejb.Stateless;

/**
 * Created by SebestyenMiklos on 2017. 03. 16..
 */
@Stateless
public class AppUserConverter implements AppUserConverterInterface {

    @Override
    public AppUserStub toAppUserStub(AppUser user) {
        AppUserStub userStub = new AppUserStub(user.getUserId(),user.getWalletId(),user.getFirst_name(),user.getLast_name());
        return userStub;
    }

}
