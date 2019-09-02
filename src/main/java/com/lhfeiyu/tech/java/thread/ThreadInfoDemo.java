package com.lhfeiyu.tech.java.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO
 *
 * @author airson
 */
public class ThreadInfoDemo {

    public static Logger logger = LoggerFactory.getLogger(ThreadInfoDemo.class);

    private static int index = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            System.out.println(i);
            //new BaseThread().start();
            Thread t = new Thread(new BaseRunnable());
            Thread t2 = new Thread(new BaseRunnable());
            t.start();
            t2.start();
            t.join();
            t2.join();
        }

    }

    static class BaseThread extends Thread {
        @Override
        public void run() {
            sync_domain();
        }
    }

    static class BaseRunnable implements Runnable {
        @Override
        public void run() {
            //domain();
            //sync_domain();
            sync_domain2();
        }
    }

    public static void domain() {
        Thread cur = Thread.currentThread();
        cur.setPriority(1);
        logger.info("{}-thread demo:{},state:{},daemon:{}", index, cur.getName(), cur.getState(), cur.isDaemon());
        for (int i = 0; i < 1000; i++) {
            index++;
        }
    }

    public static synchronized void sync_domain() {
        Thread cur = Thread.currentThread();
        cur.setPriority(1);
        logger.info("{}-thread demo:{},state:{},daemon:{}", index, cur.getName(), cur.getState(), cur.isDaemon());
        for (int i = 0; i < 1000; i++) {
            index++;
        }
    }

    public static void sync_domain2() {
        Thread cur = Thread.currentThread();
        cur.setPriority(1);
        logger.info("{}-thread demo:{},state:{},daemon:{}", index, cur.getName(), cur.getState(), cur.isDaemon());
        for (int i = 0; i < 1000; i++) {
            synchronized (ThreadInfoDemo.class) {
                index++;
            }
        }
    }


}
