package com.lkf.lock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2018/9/16
 */
public class FairAndUnFairDemo {
    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);

    public static void fair() {
        testLock(fairLock);
    }


    public void unfair() {
        testLock(unfairLock);
    }

    private static void testLock(Lock lock) {
        for (int i=0;i<5;i++){
            new Job(lock).start();
        }
    }

    public static void main(String[] args) {
        fair();
    }

    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            // 连续 2 次 打印 当前 的 Thread 和 等待 队列 中的 Thread（ 略）
            System.out.println("当前线程："+Thread.currentThread().getName());
            System.out.println("当前线程："+lock);
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }


}
