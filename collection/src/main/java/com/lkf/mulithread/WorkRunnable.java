package com.lkf.mulithread;

public class WorkRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Doing WorkRunnable processing - START " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            doSomething();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Doing WorkRunnable processing - END " + Thread.currentThread().getName());
    }

    private void doSomething() throws InterruptedException {
        System.out.println("WorkRunnable do something");
        Thread.sleep(2000);
        System.out.println("WorkRunnable sleep 2000 millis");
    }
}
