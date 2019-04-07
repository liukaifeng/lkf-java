package com.lkf.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/6
 */
public class ListExample {
    public static void main(String args[]) {
        List<String> vowels = new ArrayList<String>();

        //add
        vowels.add("A");
        vowels.add("I");

        //将元素插入到指定位置
        vowels.add(1, "E");
        System.out.println("将元素插入到指定位置 vowels.add(1,E)：" + vowels);

        List<String> list = new ArrayList<String>();
        list.add("O");
        list.add("U");

        //将集合 list 的所有元素，追加到集合 vowels 中
        vowels.addAll(list);
        System.out.println("集合元素追加到另一个集合：" + vowels);

        //清空集合元素
        list.clear();

        //集合元素大小
        System.out.println("vowels 大小： " + vowels.size());

        //替换指定位置的元素
        vowels.set(2, "E");
        System.out.println("将索引位置为2的元素替换为 E：" + vowels);

        //subList
        vowels.clear();
        vowels.add("E");
        vowels.add("E");
        vowels.add("I");
        vowels.add("O");
        //截取集合 vowels 中索引位置从 0 到 索引位置为 1 的元素
        list = vowels.subList(0, 2);
        System.out.println("vowels： " + vowels + ", vowels.subList(0, 2)：" + list);
        //替换集合 vowels 中索引位置为 0 的元素
        vowels.set(0, "A");
        System.out.println("vowels： " + vowels + ", vowels.set(0, A) " + list);
        list.add("U");
        System.out.println("vowels： " + vowels + ", list：" + list);


    }

}
