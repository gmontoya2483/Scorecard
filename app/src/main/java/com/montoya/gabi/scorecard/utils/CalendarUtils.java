package com.montoya.gabi.scorecard.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Gabriel on 18/06/2017.
 */

public class CalendarUtils {

    public static String getFormattedDate(long DateTimeMilliSeconds, String dateFormat)
    {
        // Create a DateFormatter object for displaying date in specified format.
        DateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(DateTimeMilliSeconds);
        return formatter.format(calendar.getTime());
    }

}
