package hu.smiklos.stmm.ejb.converter;

import hu.smiklos.stmm.ejb.domain.UserTypeStub;
import hu.smiklos.stmm.pers.entity.UserType;

import javax.ejb.Stateless;

/**
 * Created by SebestyenMiklos on 2017. 03. 26..
 */
@Stateless
public class UserTypeConverter implements UserTypeConverterInterface {

    @Override
    public UserTypeStub toUserTypeStub(UserType user) {
        UserTypeStub stub = new UserTypeStub(user.getUsertype());
        return stub;
    }
}
