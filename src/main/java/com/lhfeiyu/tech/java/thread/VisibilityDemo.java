package com.lhfeiyu.tech.java.thread;

/**
 * TODO
 *
 * @author airson
 */
public class VisibilityDemo {

    private static boolean shutdown = false;

    static class HelloThread extends Thread {
        @Override
        public void run() {
            while (!shutdown) {
                // do nothing
            }
            System.out.println("exit hello");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new HelloThread();
        t.start();
        Thread.sleep(1000);
        shutdown = true;
        System.out.println("exit main");
    }
}