package hu.smiklos.stmm.ejb.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SebestyenMiklos on 2017. 04. 02..
 */
public class UserRegistrationStubTest {

    UserRegistrationStub stub;

    @Before
    public void setUp() throws Exception {
        stub = new UserRegistrationStub();
    }


    @Test
    public void isValidTest() throws Exception {
        stub.setFirst_name("John");
        stub.setLast_name("Konor");
        stub.setUsername("jKonor");
        stub.setPassword("PaSSwOr3%");
        stub.setPassword_again("PaSSwOr3%");
        Assert.assertEquals(true, stub.isValid());
    }

    @Test
    public void passwordMissmatchTest() throws Exception {
        stub.setFirst_name("John");
        stub.setLast_name("Konor");
        stub.setUsername("jKonor");
        stub.setPassword("PaSSwOr3%");
        stub.setPassword_again("PawOr3%");
        Assert.assertEquals(false, stub.isValid());
    }

}