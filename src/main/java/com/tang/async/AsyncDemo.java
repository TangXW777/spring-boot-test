package com.tang.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Slf4j
@Component
public class AsyncDemo {

    @Async
    public void asyncSimple(){
        System.out.println(Thread.currentThread().getName());
        log.info("asyncSimple");
    }

    @Async
    public void asyncSimpleWithParams(int i){
        System.out.println(Thread.currentThread().getName());
        log.info("asyncSimpleWithParams, params={}", i);
    }


    @Async
    public Future<String> asyncWithReturnFuture(int i){
        System.out.println(Thread.currentThread().getName());
        log.info("asyncWithReturnFuture, params={}", i);
        Future<String> future;

        /**
         * 异步返回，future.get()会阻塞执行线程
         */
        try {
            Thread.sleep(2000);
            future = new AsyncResult<>("success:" + i);
        }catch (InterruptedException e){
            future = new AsyncResult<>("error");
        }

        return future;

    }

}
