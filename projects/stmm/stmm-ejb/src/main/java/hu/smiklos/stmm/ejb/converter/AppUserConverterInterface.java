package hu.smiklos.stmm.ejb.converter;

import hu.smiklos.stmm.ejb.domain.AppUserStub;
import hu.smiklos.stmm.pers.entity.AppUser;

import javax.ejb.Local;

/**
 * Created by SebestyenMiklos on 2017. 03. 16..
 */
@Local
public interface AppUserConverterInterface {

    public AppUserStub toAppUserStub(AppUser user);

}
