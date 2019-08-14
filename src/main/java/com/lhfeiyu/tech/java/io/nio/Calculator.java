package com.lhfeiyu.tech.java.io.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户端线程
 *
 * @author yangtao__anxpp.com
 * 用于处理一个客户端的Socket链路
 */
public class Calculator {

    private static Logger logger = LoggerFactory.getLogger(Calculator.class);

    public static Object cal(String expression) {
        logger.info("cal expression:{}", expression);
        return 1;
    }
}
