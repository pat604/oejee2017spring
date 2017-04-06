package hu.smiklos.stmm.ejb.common;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SebestyenMiklos on 2017. 04. 02..
 */
public class ErrorsTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addAndgetTest() throws Exception {
        Errors errors = new Errors();
        errors.add("password", "Empty password");
        Assert.assertEquals("Empty password", errors.get("password"));
    }

    @Test
    public void hasErrorFalseTest() throws Exception {
        Errors errors = new Errors();
        Assert.assertTrue(!errors.hasError());
    }

    @Test
    public void hasErrorTrueTest() throws Exception {
        Errors errors = new Errors();
        errors.add("last_name", "Empty Last name");
        Assert.assertTrue(errors.hasError());
    }

}