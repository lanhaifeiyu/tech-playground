package com.lhfeiyu.tech.java.base;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/**
 * @author airson
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        //formatString();
        nullCheck();
    }


    public static void nullCheck() {
        Integer a = null;
        Integer b = null;
        if (a != b) {
            System.out.println("null pass");
        }

        if(a != 3){
            System.out.println("null pass 2");
        }

        List<Integer> list = null;
        for (Integer i : list) {
            System.out.println(i);
        }


    }

}
