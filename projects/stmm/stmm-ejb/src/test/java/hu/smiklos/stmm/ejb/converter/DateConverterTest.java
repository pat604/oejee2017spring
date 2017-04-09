package hu.smiklos.stmm.ejb.converter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by SebestyenMiklos on 2017. 03. 29..
 */
public class DateConverterTest {


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getDateAsContinouesString() throws Exception {
        String string = "2010/01/02";
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = format.parse(string);
        String dateString = DateConverter.getDateAsContinouesString(date);
        Assert.assertEquals("20100102", dateString);
    }

    @Test
    public void getDateHyphenSeparated() throws Exception {
        String string = "2010/02/02";
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = format.parse(string);
        String dateString = DateConverter.getDateHyphenSeparated(date);
        Assert.assertEquals("2010-02-02", dateString);
    }

    @Test
    public void getDateAsContinouesStringDecember() throws Exception {
        String string = "2010/12/02";
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = format.parse(string);
        String dateString = DateConverter.getDateAsContinouesString(date);
        Assert.assertEquals("20101202", dateString);
    }

    @Test
    public void getDateHyphenSeparatedDecember() throws Exception {
        String string = "2010/12/02";
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = format.parse(string);
        String dateString = DateConverter.getDateHyphenSeparated(date);
        Assert.assertEquals("2010-12-02", dateString);
    }

}