package com.lhfeiyu.tech.java.generictype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * TODO
 *
 * @author airson
 */
public class GenerictypeDemo {

    public static Logger logger = LoggerFactory.getLogger(GenerictypeDemo.class);

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>();

        GenerictypeDemo demo = new GenerictypeDemo();
        MyType<Integer>  data = new MyType<>();
        demo.add(data);


    }

    public void add(MyType<? extends Number> data){


    }

}
