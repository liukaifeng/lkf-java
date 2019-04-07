package com.lkf.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/6
 */
public class ListIteratorExample {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();

        //简单遍历
        System.out.print("简单迭代遍历：");
        while (iterator.hasNext()) {
            int i = iterator.next();
            System.out.print(i + ", ");
        }

        //使用迭代器修改列表
        iterator = list.iterator();
        while (iterator.hasNext()) {
            int x = iterator.next();
            if (x % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println();
        System.out.println("使用迭代器删除偶数："+list);

        //迭代时改变列表结构
        iterator = list.iterator();
        while (iterator.hasNext()) {
            int x = iterator.next();
            //ConcurrentModificationException
            if (x == 1) {
                list.add(10);
            }
        }
    }
}
