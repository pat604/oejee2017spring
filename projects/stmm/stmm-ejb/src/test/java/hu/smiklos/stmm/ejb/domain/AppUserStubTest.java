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
    private final String firstName = "First";
    private final String secondName = "Second";


    @Before
    public void createUserStub() {
        user = new AppUserStub(appuserId,walletId,firstName,secondName);
    }


    @Test
    public void getAppuserId() throws Exception {
        assertEquals(user.getAppuserId(),appuserId);
    }

    @Test
    public void getWalletId() throws Exception {

    }

}