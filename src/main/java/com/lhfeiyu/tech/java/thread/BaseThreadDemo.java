package com.lhfeiyu.tech.java.thread;

/**
 * TODO
 *
 * @author airson
 */
public class BaseThreadDemo {

    private static int index = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(i);
            //new BaseThread().start();
            new Thread(new BaseRunnable()).start();
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
            domain();
        }
    }

    public static void domain() {
        System.out.println((++index) + "-thread demo:" + Thread.currentThread().getName());
    }

    public static synchronized void sync_domain() {
        System.out.println((++index) + "-thread demo:" + Thread.currentThread().getName());
    }


}
