package com.lkf.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2018/9/9
 */
public class LockDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            //操作代码
        } finally {
            lock.unlock();
        }
    }
}
