package com.lkf.collection.queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/7
 */
public class ArrayToQueue {
    public static void main(String[] args) {

        String nums[] = {"one", "two", "three", "four", "five"};
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, nums);
        System.out.println(queue);
    }
}
