package com.lkf.condition;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有界队列
 *
 * @author kaifeng
 * @date 2019/1/1
 */
public class BoundedQueue {
    //定义为数组，在创建对象时就确定容量
    private Integer[] items;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    // 添加的下标，删除的下标和数组当前元素数量
    private int addIndex, removeIndex, count;

    public BoundedQueue(int size) {
        items = new Integer[size];
    }

    /**
     * 添加一个元素，如果数组满了，则添加线程进入等待状态
     *
     * @param object 添加的元素
     */
    public void add(Integer object) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[addIndex] = object;
            if (++addIndex == items.length) {
                addIndex = 0;
            }
            count++;
            System.out.println(Thread.currentThread() + " 新增一个元素，当前数组为：" + Arrays.toString(items));
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 从头部删除一个元素，如果数组为空，则删除线程进入等待状态，直到有新元素添加
     */
    @SuppressWarnings("unchecked")
    public Integer remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            Integer temp = items[removeIndex];
            items[removeIndex] = null;
            System.out.println(Thread.currentThread() + " 读取一个元素，当前数组为：" + Arrays.toString(items));
            if (++removeIndex == items.length) {
                removeIndex = 0;
            }
            count--;
            notFull.signal();
            return temp;
        } finally {
            lock.unlock();
        }


    }
}
