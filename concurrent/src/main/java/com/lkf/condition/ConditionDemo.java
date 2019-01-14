package com.lkf.condition;

import java.util.Random;
import java.util.function.Consumer;

/**
 * 有界队列测试
 *
 * @author kaifeng
 * @date 2019/1/1
 */
public class ConditionDemo {
    private final static Random random = new Random();

    public static void main(String[] args) {
        BoundedQueue queue = new BoundedQueue(5);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new ProducterRunable(queue), "ProdducterThread_".concat(String.valueOf(i)));
            thread.start();
        }

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new ConsumerRunable(queue), "ConsumerThread_".concat(String.valueOf(i)));
            thread.start();
        }

    }

    /**
     * 插入元素到队列
     */
    static class ProducterRunable implements Runnable {
        private BoundedQueue queue;

        public ProducterRunable(BoundedQueue queue) {
            this.queue = queue;
        }

        public void produce() throws InterruptedException {
            queue.add(new Integer(random.nextInt(100)));
        }

        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从队列读取元素
     */
    static class ConsumerRunable implements Runnable {
        private BoundedQueue queue;

        public ConsumerRunable(BoundedQueue queue) {
            this.queue = queue;
        }

        public Integer remove() throws InterruptedException {
            return queue.remove();
        }

        @Override
        public void run() {
            try {
                remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
