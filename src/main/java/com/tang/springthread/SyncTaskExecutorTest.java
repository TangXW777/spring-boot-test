package com.tang.springthread;

import org.springframework.core.task.SyncTaskExecutor;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 同步执行，每次调用都会在发起调用的线程中执行
 * 类似JAVA线程池的SingleThreadPool
 */
public class SyncTaskExecutorTest {

    public static void main(String[] args) {
        SyncTaskExecutor syncTaskExecutor = new SyncTaskExecutor();

        Runnable[] runnables = new Runnable[10];
        IntStream.range(0, 10).forEach(i -> runnables[i] = () -> {
            if(i == 3){
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();

                }
            }
            System.out.println("index = " + i + ", thread name = " + Thread.currentThread().getName());
        });

        Arrays.stream(runnables).forEach(syncTaskExecutor::execute);
    }
}
