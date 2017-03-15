package hu.smiklos.stmm.ejb.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SebestyenMiklos on 2017. 03. 14..
 */
public class AppUserStubTest {
    AppUserStub user;
    private final String appuserId = "EMEA-HU-12345";
    private final String walletId = "HU-123456798";

    @Before
    public void createUserStub() {
        user = new AppUserStub(appuserId,walletId);
    }


    @Test
    public void getAppuserId() throws Exception {
        assertEquals(user.getAppuserId(),appuserId);
    }

    @Test
    public void getWalletId() throws Exception {

    }

}