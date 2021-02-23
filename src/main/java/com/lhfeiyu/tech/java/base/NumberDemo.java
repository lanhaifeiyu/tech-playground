package com.lhfeiyu.tech.java.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author airson
 */
public class NumberDemo {

    public static void main(String[] args) {
        //formatString();
        //number_mod();
        number_compare();
    }

    public static void number_mod() {
        int a = 202011;
        int b = 202011 % 100;


        System.out.println("module:" + b);


    }

    public static void number_compare() {
        List<Integer> uidByCerId = new ArrayList<>();
        uidByCerId.add(123545);
        Integer num = 123545;
        if (uidByCerId.size() == 1 && uidByCerId.get(0) != num.intValue()) {
            System.out.println("result true");
        }





    }

}
