package hu.smiklos.stmm.ejb.common;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SebestyenMiklos on 2017. 04. 02..
 */
public class PasswordTest {

    final private static String PASSWORD = "VerySecret@Pa88word";
    Password pw;
    private String hashedPw;

    @Before
    public void setUp() {
        pw = new Password(PASSWORD);
        this.hashedPw = pw.getHashedPassword();
    }

    @Test
    public void getHashedPassword() throws Exception {
        int pwLength = hashedPw.length();
        Assert.assertTrue(pwLength == 60);
    }

    @Test
    public void checkPasswordOk() throws Exception {
            Assert.assertTrue(pw.checkPassword(PASSWORD,hashedPw));
    }

    @Test
    public void checkPasswordFalse() throws Exception {
        char[] hashArray = hashedPw.toCharArray();
        hashArray[hashArray.length - 1] = 'X';
        Assert.assertTrue(!pw.checkPassword(PASSWORD,new String(hashArray)));
    }

}