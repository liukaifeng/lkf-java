package com.lkf.collection.set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/5
 */
public class SetSortingExample {
    public static void main(String[] args) {
        Set<Integer> intsSet = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            intsSet.add(random.nextInt(1000));
        }
        System.out.println("无序Set: " + intsSet);
        Set<Integer> sortedSet = new TreeSet<>(intsSet);
        System.out.println("有序Set: " + sortedSet);
    }
}
