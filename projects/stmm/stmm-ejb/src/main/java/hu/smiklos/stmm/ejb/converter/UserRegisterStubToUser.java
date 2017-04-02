package hu.smiklos.stmm.ejb.converter;

import hu.smiklos.stmm.ejb.domain.UserRegistrationStub;
import hu.smiklos.stmm.pers.entity.AppUser;

import javax.ejb.Stateless;

/**
 * Created by SebestyenMiklos on 2017. 03. 30..
 */
@Stateless
public class UserRegisterStubToUser implements UserRegisterStubToUserInterface {

    @Override
    public AppUser formToAppUser(UserRegistrationStub stub) {
        AppUser user = new AppUser();
        user.setFirst_name(stub.getFirst_name());
        user.setLast_name(stub.getLast_name());
        user.setUserId(stub.getUserId());
        user.setUsername(stub.getUsername());
        return user;
    }
}
