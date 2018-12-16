package com.lkf;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2018/9/2
 */
public class MyRunnable implements Runnable {
    private long i;
    private volatile boolean on = true;

    @Override
    public void run() {
        while (on && !Thread.currentThread().isInterrupted()) {
            i++;
        }
        System.out.println(" Count i = " + i);
    }

    public void cancel() {
        on = false;
    }
}
