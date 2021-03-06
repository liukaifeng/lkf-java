package com.lkf.locksurpport;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2018/12/16
 */
public class ObjectWaitDemo {
    public static void main(String[] args) throws Exception {
        final Object obj = new Object();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 100; i++) {
                    sum += i;
                }
                try {
                    synchronized (obj) {
                        obj.wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(sum);
            }
        });
        thread1.start();
        Thread.sleep(1000);
        synchronized (obj) {
            obj.notify();
        }
    }
}
