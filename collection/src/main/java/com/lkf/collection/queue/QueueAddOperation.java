package com.lkf.collection.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/7
 */
public class QueueAddOperation {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        System.out.println(queue.add("one"));
        System.out.println(queue.add("two"));
        System.out.println("队列中的元素："+queue);
        System.out.println("下面的add操作将抛出异常：");
        System.out.println(queue.add("three"));
    }
}
