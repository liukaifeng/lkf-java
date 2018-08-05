package com.lkf.mulithread;

public class WorkExtendThread extends Thread {
    public WorkExtendThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("WorkExtendThread - START " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            doSomething();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("WorkExtendThread - END " + Thread.currentThread().getName());
    }

    private void doSomething() throws InterruptedException {
        System.out.println("WorkExtendThread do something");
        Thread.sleep(2000);
        System.out.println("WorkExtendThread sleep 2000 millis");
    }
}
