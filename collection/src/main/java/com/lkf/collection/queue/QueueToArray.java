package com.lkf.collection.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/7
 */
public class QueueToArray {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        queue.add("one");
        queue.add("two");
        queue.add("three");
        queue.add("four");
        queue.add("five");

        String strArray[] = queue.toArray(new String[queue.size()]);
        System.out.println("队列转换为数组：" + Arrays.toString(strArray));

    }
}
