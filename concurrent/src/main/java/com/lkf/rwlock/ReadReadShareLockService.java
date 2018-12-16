package com.lkf.rwlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2018/12/9
 */
public class ReadReadShareLockService {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
            try {
                lock.readLock().lock();
                System.out.println(" 获得 读 锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();

            }
    }
}
