package com.lkf.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;


public class CountDownlatchTest {
    /**
     * 计数器，用来控制线程数量，传入参数2，表示计数器计数为2
     */
    private final static CountDownLatch M_COUNT_DOWN_LATCH = new CountDownLatch(2);

    /**
     * 示例工作线程类
     */
    private static class WorkerThreadA implements Runnable {
        private final String mThreadName;
        private final int mSleepTime;

        public WorkerThreadA(String name, int sleepTime) {
            mThreadName = name;
            mSleepTime = sleepTime;
        }

        @Override
        public void run() {
            System.out.println("[" + mThreadName + "] started!");
            try {
                Thread.sleep(mSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            M_COUNT_DOWN_LATCH.countDown();
            System.out.println("[" + mThreadName + "] end!");
        }
    }

    /**
     * 工作线程类
     */
    private static class WorkerThreadB implements Runnable {

        @Override
        public void run() {
            System.out.println("[WorkerThread] started!");
            try {
                // 阻塞在这里等待 mCountDownLatch 里的count变为0；                
                M_COUNT_DOWN_LATCH.await();
            } catch (InterruptedException e) {

            }
            System.out.println("[WorkerThread] end!");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = newFixedThreadPool(3);
        // 最先run WorkerThread
        executorService.submit(new WorkerThreadB());
        // 运行两个工作线程
        // 工作线程1运行3秒        
        executorService.submit(new WorkerThreadA("WorkingThread1", 3000));
        // 工作线程2运行2秒
        executorService.submit(new WorkerThreadA("WorkingThread2", 2000));
    }
}
