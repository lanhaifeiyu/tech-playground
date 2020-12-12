package com.lhfeiyu.tech.java.generictype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author airson
 */
public class MyType<T> {

    public static Logger logger = LoggerFactory.getLogger(MyType.class);

    public T add(T t) {

        return t;

    }

}
