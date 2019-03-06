package com.tang.javathread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * java缓冲线程池，可回收空闲线程，如果没有可回收的，则会创建新线程
 */
public class CachedThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i < 10; i++){
            executorService.execute(new TestTask());
        }
    }


    static class TestTask implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
