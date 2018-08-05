package com.lkf.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class ExchangerTest {
    //交换器
    private static final Exchanger<String> exgr = new Exchanger<String>();

    //线程池
    private static ExecutorService threadPool = newFixedThreadPool(2);

    public static void main(String[] args) {

        threadPool.execute(() -> {
            try {
                String threadAData = "线程A的数据";
                String threadBData = exgr.exchange(threadAData);
                System.err.println("线程A得到B——》" + threadBData);
            } catch (InterruptedException e) {
            }
        });

        threadPool.execute(() -> {
            try {
                String threadBData = "线程B的数据";
                String threadAData = exgr.exchange(threadBData);
                System.err.println("线程B得到A——》" + threadAData);
            } catch (InterruptedException e) {
            }
        });

        threadPool.shutdown();

    }
}
