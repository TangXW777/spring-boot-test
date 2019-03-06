package com.tang.javathread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * java定时线程
 */
public class ScheduleThreadPoolTest {

    public static void main(String[] args) {
        run1();
        run2();
    }

    public static void run1(){
        // 延迟3s后执行
        ScheduledExecutorService executorService1 = Executors.newScheduledThreadPool(3);
        executorService1.schedule(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("3 seconds delay");
        }, 3, TimeUnit.SECONDS);

    }

    public static void run2(){
        // 延迟1s后执行，然后每3秒执行一次
        ScheduledExecutorService executorService1 = Executors.newScheduledThreadPool(3);
        executorService1.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("3 seconds delay");
        }, 1, 3, TimeUnit.SECONDS);
    }
}
