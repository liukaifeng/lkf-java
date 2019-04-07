package com.lkf.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/7
 */
public class QueueRemoveOperation {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("two");
        System.out.println("队列中的元素：" + queue);
        System.out.println("删除第一个元素：" + queue.remove());
        System.out.println("删除第二个元素：" + queue.remove());
        System.out.println("删除第三个元素：" + queue.remove());
    }
}
