package com.lkf.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/5
 */
public class SetIteratorExample {
    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            set.add(i);
        }

        //获取迭代器
        Iterator iterator = set.iterator();

        //简单迭代
        System.out.println("迭代集合元素：");
        while (iterator.hasNext()) {
            int i = (int) iterator.next();
            System.out.print(i + " ");
        }

        //使用迭代器修改 set 元素
        iterator = set.iterator();
        while (iterator.hasNext()) {
            int x = (int) iterator.next();
            if (x % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println();
        System.out.println("使用迭代器修改set元素以后：" + set);

        //迭代时改变set结构
        iterator = set.iterator();
        System.out.println("迭代时改变set结构，ConcurrentModificationException：" );

        while (iterator.hasNext()) {
            //ConcurrentModificationException
            int x = (int) iterator.next();
            if (x == 1) {
                set.add(10);
            }
        }
    }
}
