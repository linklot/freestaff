package com.iceroom.fundamental.util;

import java.util.Comparator;

/**
 * @author Lincoln
 *
 */
public class StringComparable implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if(s1.compareTo(s2) > 0) return -1;
        if(s1.equals(s2)) return 0;
        else return 1;
    }
    
}
