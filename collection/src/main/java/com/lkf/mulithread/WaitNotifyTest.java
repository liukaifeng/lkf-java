package com.lkf.mulithread;

public class WaitNotifyTest {
    public static void main(String[] args) {
        Message msg = new Message("process it");
        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "1号线程").start();

        Waiter waiter2 = new Waiter(msg);
        new Thread(waiter2, "2号线程").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "唤醒线程").start();
        System.out.println("所有线程启动完毕");
    }
}
