package hu.smiklos.stmm.ejb.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by SebestyenMiklos on 2017. 03. 29..
 */
public class DateConverter {

    public static String getDateAsContinouesString(Date date) {
            DateFormat sdf = new SimpleDateFormat("yyyymmdd");
            String dateString = sdf.format(date);
            return dateString;
    }

    public static String getDateHyphenSeparated(Date date) {
        DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String dateString = sdf.format(date);
        return dateString;
    }

    public static Date getTodayDate(){
        Date today = Calendar.getInstance().getTime();
        return today;
    }
}
