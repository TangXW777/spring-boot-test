package com.tang.javathread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * java单线程池，只会有唯一的工作线程来执行任务，保证FIFO优先级
 */
public class SingleThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++){
            executorService.execute(() -> {

                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        }
    }
}
