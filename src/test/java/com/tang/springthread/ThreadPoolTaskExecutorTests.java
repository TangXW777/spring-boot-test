package com.tang.springthread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.TaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.stream.IntStream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ThreadPoolTaskExecutorTests {

    @Autowired
    @Qualifier("myThreadPoolTaskPool")
    private TaskExecutor myThreadPoolTaskPool;

    @Test
    public void test(){

        Runnable[] threads = new Runnable[10];

        // 初始化数组
        IntStream.range(0, 10)
                .forEach(i -> threads[i] = () -> System.out.println(Thread.currentThread().getName()));

        // 线程池执行
        Arrays.stream(threads).forEach(myThreadPoolTaskPool::execute);

    }


}
