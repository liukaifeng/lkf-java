package com.lkf.locksurpport;

import java.util.concurrent.locks.LockSupport;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2018/12/16
 */
public class LockSurpportDemo {
    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }
                //阻塞当前线程
                LockSupport.park();
                System.out.println(sum);
            }
        });
        thread1.start();
        Thread.sleep(1000);
        //唤醒指定线程
        LockSupport.unpark(thread1);
    }
}
