package com.lhfeiyu.tech.java.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.*;

/**
 * TODO
 *
 * @author airson
 */
public class ExecutorDemo {

    public static Logger logger = LoggerFactory.getLogger(ExecutorDemo.class);

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int sleepSeconds = new Random().nextInt(1000);
            Thread.sleep(sleepSeconds);
            return sleepSeconds;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new Task());
        //模拟执行其他任务
        Thread.sleep(100);
        try {
            logger.info("future.get:{}", future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

}
