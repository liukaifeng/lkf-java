package com.lkf.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 反转队列前K个元素
 * <p>
 * 把前k个元素压栈，然后放入新队列中，最后将剩下的元素都添加到新队列中
 *
 * @author kaifeng
 */
public class QueueReverseK {
    public static void reverseKQueue(Queue queue, int k) {
        Stack stack = new Stack();
        Queue newQueue = new LinkedList();
        int size = queue.size();
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }
        for (int i = 0; i < size; i++) {
            if (i < k) {
                newQueue.offer(stack.pop());
            } else {
                newQueue.offer(queue.poll());
            }
        }
        //打印
        while (newQueue.size() > 0) {
            System.out.println(newQueue.poll());
        }
    }
}
