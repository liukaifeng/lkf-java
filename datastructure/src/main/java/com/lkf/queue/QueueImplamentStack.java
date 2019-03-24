package com.lkf.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈
 *
 * @author kaifeng
 * @date 2019/3/24
 */
public class QueueImplamentStack {
    //数据队列
    private static Queue originalQueue = new LinkedList();
    //辅助队列
    private static Queue helpQueue = new LinkedList();

    public static void main(String[] args) {
        System.out.println("入栈的元素：");
        //添加数据到数据队列
        for (int i = 1; i < 6; i++) {
            System.out.print(i + " ");
            originalQueue.add(i);
        }
        System.out.println();
        System.out.println("出栈的元素：");
        for (int i = 1; i < 6; i++) {
            //获取元素
            System.out.print(popElement() + " ");
        }
    }

    /**
     * 获取元素
     */
    private static Object popElement() {
        if (originalQueue.isEmpty()) {
            return popElementFromOriginalQueue();
        } else {
            return popElementFromHelpQueue();
        }
    }

    /**
     * 将辅助队列的元素放入数据队列，并将辅助队列的最后一个元素出队
     */
    private static Object popElementFromOriginalQueue() {
        int size = helpQueue.size();
        for (int i = 1; i < size; i++) {
            originalQueue.add(helpQueue.poll());
        }
        return helpQueue.poll();
    }

    /**
     * 将数据队列的元素放入辅助队列，并将数据队列的最后一个元素出队
     */
    private static Object popElementFromHelpQueue() {
        int size = originalQueue.size();
        for (int i = 1; i < size; i++) {
            helpQueue.add(originalQueue.poll());
        }
        return originalQueue.poll();
    }

}
