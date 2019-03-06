package com.tang.springthread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadPoolTaskExecutorTest {

    // Demo请看test(com.tang.springthread.ThreadPoolTaskExecutorTest)


    /**
     * 创建一个线程池，用于测试
     * @return
     */
    @Bean("myThreadPoolTaskPool")
    public TaskExecutor myThreadPoolTaskPool(){


        /**
         * 线程创建策略：
         * 当一个任务被提交到线程池时，首先查看线程池的核心线程是否都在执行任务，否就选择一条线程执行任务，是就执行第二步。
         * 查看核心线程池是否已满，不满就创建一条线程执行任务，否则执行第三步。
         * 查看任务队列是否已满，不满就将任务存储在任务队列中，否则执行第四步。
         * 查看线程池是否已满，不满就创建一条线程执行任务，否则就按照策略处理无法执行的任务。
         */

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(20); // 设置线程池核心线程数
        threadPoolTaskExecutor.setMaxPoolSize(200); // 设置线程池最大线程数
        threadPoolTaskExecutor.setQueueCapacity(200); // 等待队列长度
        threadPoolTaskExecutor.setKeepAliveSeconds(3000); // 等待时间
        threadPoolTaskExecutor.setThreadNamePrefix("My-Thread-Pool-"); // 线程名

        /**
         * 拒绝策略：
         * AbortPolicy，用于被拒绝任务的处理程序，它将抛出RejectedExecutionException。
         * CallerRunsPolicy，用于被拒绝任务的处理程序，它直接在execute方法的调用线程中运行被拒绝的任务（主线程中执行）
         * DiscardOldestPolicy，用于被拒绝任务的处理程序，它放弃最旧的未处理请求，然后重试execute。
         * DiscardPolicy，用于被拒绝任务的处理程序，默认情况下它将丢弃被拒绝的任务。
         */
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy()); // 拒绝策略
        return threadPoolTaskExecutor;
    }
}
