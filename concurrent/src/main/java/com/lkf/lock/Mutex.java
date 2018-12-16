package com.lkf.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2018/9/16
 */
public class Mutex implements Lock {
    // 静态 内 部类， 自定义 同步 器
    private static class Sync extends AbstractQueuedSynchronizer {
        // 是否 处于 占用 状态
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        // 当 状态 为 0 的 时候 获取 锁
        @Override
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // 释放 锁， 将 状态 设置 为 0
        @Override
        protected boolean tryRelease(int releases) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // 返回 一个 Condition， 每个 condition 都 包含 了 一个 condition 队列
        Condition newCondition() {
            return new ConditionObject();
        }
    }

    // 仅 需要 将 操作 代理 到 Sync 上 即可
    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }
}

