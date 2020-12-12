package com.lhfeiyu.tech.java.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO
 *
 * @author airson
 */
public class WaitNotifyDemo {

    public static Logger logger = LoggerFactory.getLogger(WaitNotifyDemo.class);

    private volatile static boolean fire = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new BaseRunnable());
        //Thread t2 = new Thread(new BaseRunnable());
        t.start();
        //t2.start();
        //t.join();
        t.sleep(1000);
        //t2.sleep(1000);
        logger.info("fire");
        fire(t);
    }

    public synchronized static void fire(Thread t) {
        WaitNotifyDemo.fire = true;
        t.notify();
    }

    static class BaseRunnable implements Runnable {
        @Override
        public void run() {
            try {
                synchronized (this) {
                    while (!WaitNotifyDemo.fire) {
                        wait();
                    }
                }
                logger.info("fired");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
