package com.lkf.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/6
 */
public class ListSortExample {
    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            ints.add(random.nextInt(1000));
        }

        //使用 Collections 对列表进行自然排序
        Collections.sort(ints);
        System.out.println("Collections 自然排序： " + ints);

        //自定义比较器，逆序排序
        ints.sort((o1, o2) -> {
            return (o2 - o1);
        });
        System.out.println("自定义 Comparator 逆序排序： " + ints);
    }
}
