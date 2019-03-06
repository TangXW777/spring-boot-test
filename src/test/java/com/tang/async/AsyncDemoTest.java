package com.tang.async;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncDemoTest {

    @Autowired
    AsyncDemo asyncDemo;

    @Test
    public void test1() throws Exception{
        asyncDemo.asyncSimple();
        asyncDemo.asyncSimpleWithParams(1);

        Future<String> future = asyncDemo.asyncWithReturnFuture(1);
        System.out.println(future.get());
    }
}
