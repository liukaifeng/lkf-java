package com.lkf.mulithread;

public class ThreadRunExample {
    public static void main(String[] args) {
        Thread implRunnableThread1 = new Thread(new WorkRunnable(), "ImplRunnableThread1");
        Thread implRunnableThread2 = new Thread(new WorkRunnable(), "ImplRunnableThread2");
        System.out.println("Starting ImplRunnableThread threads");
        implRunnableThread1.start();
        implRunnableThread2.start();
        System.out.println("Runnable ImplRunnableThread has been started");

        Thread workExtendThread3 = new WorkExtendThread("WorkExtendThread3");
        Thread workExtendThread4 = new WorkExtendThread("WorkExtendThread4");
        System.out.println("ExtendThreads MyThreads");
        workExtendThread3.start();
        workExtendThread4.start();
        System.out.println("ExtendThreads has been started");

    }
}
