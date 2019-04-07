package com.lkf.collection.set;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetExample {
    public static void main(String[] args) {
        SortedSet<String> fruits = new TreeSet<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("banana");
        fruits.add("watermelon");

        System.out.println("SortedSet: " + fruits);
        System.out.println("SortedSet First: " + fruits.first());
        System.out.println("SortedSet Last: " + fruits.last());

        // 获取 orange(不包含) 之前的元素
        SortedSet<String> beforeOrange = fruits.headSet("orange");
        System.out.println("获取 orange(不包含) 之前的元素：" + beforeOrange);

        // 获取 apple (包含) 和 watermelon (不包含) 之间的元素
        SortedSet<String> betweenAppleAndWatermelon = fruits.subSet("apple", "watermelon");
        System.out.println("获取 apple (包含) 和 watermelon (不包含) 之间的元素：" + betweenAppleAndWatermelon);

        // 获取 banana (包含) 之后的元素
        SortedSet<String> afterCode = fruits.tailSet("banana");
        System.out.println("获取 banana (包含) 之后的元素：" + afterCode);
        
    }
}
