package com.tang.springthread;

import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.concurrent.Future;

/**
 * spring线程池，每个任务都会开一个新的线程
 * 允许开发者控制并发线程的上限（concurrencyLimit）
 * 支持任务回调
 */
public class SimpleAsyncTaskExecutorTest {

    public static void main(String[] args) throws Exception{
        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        taskExecutor.setConcurrencyLimit(3); // 设置最大并发数,超过最大并发数，则等待

        // execute(Runnable task)
        // 执行任务，没有返回值
        taskExecutor.execute(() -> System.out.println("this is taskExecutor.execute")); // 执行一个任务

        // submit(Callable<T> task)
        // 返回一个对象
        Future<?> future = taskExecutor.submit(() -> System.out.println("this is taskExecutor.submit"));

        Future<?> future2 = taskExecutor.submit(() -> {
            try {
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
            return "success";
        });

        // get()会阻塞当前线程，直到结果返回
        System.out.println((String) future2.get());


    }
}
