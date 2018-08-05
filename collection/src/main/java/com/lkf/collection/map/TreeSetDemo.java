package com.lkf.collection.map;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        //指定一个比较器，倒置元素顺序
        TreeSet<String> treeSet = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < 5; i++) {
            treeSet.add("item" + i);
        }
        for (int i = 0; i < 5; i++) {
            treeSet.add("item" + i);
        }

        treeSet.forEach(item -> {
            System.err.println(item);
        });

    }
}
