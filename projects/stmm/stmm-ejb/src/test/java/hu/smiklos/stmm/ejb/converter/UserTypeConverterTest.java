package hu.smiklos.stmm.ejb.converter;

import hu.smiklos.stmm.ejb.domain.UserTypeStub;
import hu.smiklos.stmm.pers.entity.UserType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SebestyenMiklos on 2017. 03. 26..
 */
public class UserTypeConverterTest {

    UserType userType;

    UserTypeConverter converter;

    @Before
    public void setUp() throws Exception {
        userType = new UserType("REGISTERED","REGISTERED");
        converter = new UserTypeConverter();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void toUserTypeStub() throws Exception {
        UserTypeStub test = converter.toUserTypeStub(userType);
        Assert.assertEquals(test.getType(),userType.getUsertype());
    }

}