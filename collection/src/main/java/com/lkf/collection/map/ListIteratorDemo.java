package com.lkf.collection.map;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/2
 */
public class ListIteratorDemo {
//    public static void main(String[] args) {
//        List<String> names = new LinkedList<>();
//        for (int i = 1; i <= 10; i++) {
//            names.add("E-" + i);
//        }
//        ListIterator<String> listIterator = names.listIterator();
//
//    }

    public static void main(String[] args) {
        List<String> names = new LinkedList<>();
        names.add("Apple");
        names.add("Orange");
        names.add("Banana");

        // 获取 ListIterator 对象
        ListIterator<String> listIterator = names.listIterator();

        // 遍历元素
        System.out.println("ListIterator遍历:");
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        System.out.println("for循环遍历:");
        for(String name: names){
            System.out.println(name);
        }
    }
}
