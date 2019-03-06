package com.tang.javathread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * java最大并发数线程池，超出的线程会在队列中等待
 */
public class FixedThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 10; i++){
            executorService.execute(new TestTask());
        }
    }


    static class TestTask implements Runnable{
        @Override
        public void run() {

            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
