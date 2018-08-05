package com.lkf.lock;

public class LockDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new SynchronizedLockExample(new Resource())).start();
//            new Thread(new ConcurrencyLockExample(new Resource())).start();
        }
    }
}
