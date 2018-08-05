package com.lkf.mulithread;

public class ThreadJoinExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable(), "线程t1");
        Thread t2 = new Thread(new MyRunnable(), "线程t2");
        Thread t3 = new Thread(new MyRunnable(), "线程t3");

        t1.start();

        //两秒钟以后启动第二个线程
        try {
            t1.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

        //第一个线程完成之后启动第三个线程
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t3.start();

        //三个子线程先执行完，然后继续主线程
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有线程执行完毕");
    }

}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread started:::" + Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ended:::" + Thread.currentThread().getName());
    }
}
