package com.lkf.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        //初始化四个线程
        int threadNum = 4;
        CyclicBarrier barrier = new CyclicBarrier(threadNum, new WorkerThreadA());
        for (int i = 0; i < threadNum; i++) {
            new WorkerThread(barrier).start();
        }
    }

    static class WorkerThread extends Thread {
        private CyclicBarrier cyclicBarrier;

        public WorkerThread(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在执行");
            try {
                Thread.sleep(5000);      //以睡眠来模拟操作
                System.out.println("线程" + Thread.currentThread().getName() + "执行完毕，等待其他线程执行完成");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程执行完成，继续处理其他任务...");
        }
    }

    static class WorkerThreadA extends Thread {
        @Override
        public void run() {
            System.err.println("我是特殊任务");
        }
    }
}
