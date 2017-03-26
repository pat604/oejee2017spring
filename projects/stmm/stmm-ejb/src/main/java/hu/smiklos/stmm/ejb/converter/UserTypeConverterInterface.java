package hu.smiklos.stmm.ejb.converter;

import hu.smiklos.stmm.ejb.domain.UserTypeStub;
import hu.smiklos.stmm.pers.entity.UserType;

import javax.ejb.Local;

/**
 * Created by SebestyenMiklos on 2017. 03. 26..
 */
@Local
public interface UserTypeConverterInterface {
    public UserTypeStub toUserTypeStub(UserType user);
}
