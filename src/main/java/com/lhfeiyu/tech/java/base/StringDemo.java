package com.lhfeiyu.tech.java.base;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

/**
 * @author airson
 */
public class StringDemo {

    public static void main(String[] args) {
        //formatString();
        nullCheck();
    }

    public static void formatString() {
        String str = MessageFormat.format("how are {0} today? good, {1}!", "you", "thank you");
        System.out.println(str);

        Boolean b = new Boolean(true);

        String str2 = String.format("how are %b today? good, %<h  %2$t  !", b, Calendar.getInstance());
        System.out.println(str2);

        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.US);
        formatter.format("how are %1$s today? good, %2$s!", "you", "thank you");
        String str3 = sb.toString();
        System.out.println(str3);

    }

    public static void nullCheck() {
        Integer a = null;
        Integer b = null;
        if (a != b) {

            System.out.println("null pass");
        }


    }

}
