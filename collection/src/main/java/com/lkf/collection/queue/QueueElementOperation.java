package com.lkf.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/7
 */
public class QueueElementOperation {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        queue.add("one");

        System.out.println(queue.element());
        System.out.println(queue);
        queue.clear();
        System.out.println(queue.element());
    }
}
