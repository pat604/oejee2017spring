package hu.smiklos.stmm.ejb.converter;

import hu.smiklos.stmm.ejb.domain.AppUserStub;
import hu.smiklos.stmm.pers.entity.AppUser;
import hu.smiklos.stmm.pers.entity.UserType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SebestyenMiklos on 2017. 03. 16..
 */
public class AppUserConverterTest {
    AppUser appUser;
    AppUserConverter appUserConverter;

    @Before
    public void setUp() throws Exception {
        appUser = new AppUser("E-HU-12345678","E-HU-W-12345678","First","Last","hjusda#345", new UserType("REGISTERED","REGISTERED"));
        appUserConverter = new AppUserConverter();
    }

    @Test
    public void toAppUserStub() throws Exception {
        AppUserStub userStub = appUserConverter.toAppUserStub(appUser);
        Assert.assertEquals(appUser.getUserId(),userStub.getAppuserId());
        Assert.assertEquals(appUser.getWalletId(),userStub.getWalletId());
        Assert.assertEquals(appUser.getFirst_name(),userStub.getFirstName());
        Assert.assertEquals(appUser.getLast_name(),userStub.getLastName());


    }

}