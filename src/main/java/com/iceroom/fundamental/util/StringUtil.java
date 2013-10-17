/**
 * 
 */
package com.iceroom.fundamental.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * @author Lincoln
 *
 */
public class StringUtil {
    
    /**
     * Get user-friendly date string.
     * @param date The original Calendar object.
     * @return The date String like "02/08/2013 13:25"
     */
    public static String getFriendlyDate(Calendar date) {
        StringBuffer sb = new StringBuffer();
        
        int day = date.get(Calendar.DAY_OF_MONTH);
        if(day < 10) sb.append("0" + day + "/");
        else sb.append(day + "/");
        
        int month = date.get(Calendar.MONTH);
        month ++;
        sb.append(month + "/");
        
        int year = date.get(Calendar.YEAR);
        sb.append(year);
        
        return sb.toString();
    }
    
    /**
     * Get user-friendly date & time string.
     * @param date The original Calendar object.
     * @return The date String like "02/08/2013"
     */
    public static String getFriendlyTime(Calendar date) {
        StringBuffer sb = new StringBuffer();
        
        int day = date.get(Calendar.DAY_OF_MONTH);
        if(day < 10) sb.append("0" + day + "/");
        else sb.append(day + "/");
        
        int month = date.get(Calendar.MONTH);
        month ++;
        sb.append(month + "/");
        
        int year = date.get(Calendar.YEAR);
        sb.append(year + " ");
        
        int hour = date.get(Calendar.HOUR_OF_DAY);
        sb.append(hour + ":");
        
        int minute = date.get(Calendar.MINUTE);
        if(minute < 10) sb.append("0" + minute);
        else sb.append(minute);
        
        return sb.toString();
    }
    
    /**
     * Get the extension name of a file name.
     * @param fileName The original file name.
     * @return The extension file name.
     */
    public static String getExtName(String fileName) {
        String[] names = fileName.split("\\.");
        return names[names.length - 1];
    }
    
    /**
     * Construct a string to represent current time, like "20130821150824"
     * @return {@link String}
     */
    public static String getCurrentTimeString() {
        Calendar calendar = GregorianCalendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        
        StringBuffer sb = new StringBuffer("" + year);
        if(month < 10) sb.append("0" + month);
        else sb.append("" + month);
        if(day < 10) sb.append("0" + day);
        else sb.append("" + day);
        if(hour < 10) sb.append("0" + hour);
        else sb.append("" + hour);
        if(minute < 10) sb.append("0" + minute);
        else sb.append("" + minute);
        if(second < 10) sb.append("0" + second);
        else sb.append("" + second);
        
        return sb.toString();
    }
    
    /**
     * Generate a random string.
     * @return {@link String}
     */
    public static String randomString() {
        String uuid = UUID.randomUUID().toString();
        String[] pieces = uuid.split("-");
        return pieces[0];
    }
    
}
