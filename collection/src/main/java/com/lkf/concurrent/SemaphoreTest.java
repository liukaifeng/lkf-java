package com.lkf.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

import static java.util.concurrent.Executors.newFixedThreadPool;

//public class SemaphoreTest {
//    public static void main(String[] args) {
//        int n = 8;            //工人数
//        Semaphore semaphore = new Semaphore(5); //机器数目
//        for(int i=0;i<n;i++) {
//            new Worker(i,semaphore).start();
//        }
//    }
//
//    static class Worker extends Thread{
//        private int num;
//        private Semaphore semaphore;
//        public Worker(int num,Semaphore semaphore){
//            this.num = num;
//            this.semaphore = semaphore;
//        }
//
//        @Override
//        public void run() {
//            try {
//                semaphore.acquire();
//                System.out.println("工人"+this.num+"占用一个机器在生产...");
//                Thread.sleep(2000);
//                System.out.println("工人"+this.num+"释放出机器");
//                semaphore.release();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//
//}

public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data");
                        s.release();
                    } catch (InterruptedException e) {
                    }
                }
            });
        }

        threadPool.shutdown();
    }
}